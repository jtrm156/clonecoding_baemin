package com.example.softsquaredproject.src.order

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.ApplicationClass.Companion.sSharedPreferences
import com.example.softsquaredproject.config.BaseFragment
import com.example.softsquaredproject.databinding.ActivityKoreanBinding
import com.example.softsquaredproject.databinding.FragmentOrderBinding
import com.example.softsquaredproject.src.home.CustomAdapter
import com.example.softsquaredproject.src.home.Foodcategory
import com.example.softsquaredproject.src.home.HomeActivity
import com.example.softsquaredproject.src.order.models.restaurantlistResonse


data class restaurantList(val restaurant_img : String,
                          val restaurant_name : String,
                          val restaurant_star : String,
                          val restaurant_reviewCnt : String,
                          val restaurant_menu : String,
                          val restaurant_delivertime : String,
                          val restaurant_orderprice : Int,
                          val restaurant_delivertip : Int,
                          val coupon : Int
                          )

class KoreanFragment: BaseFragment<ActivityKoreanBinding>(ActivityKoreanBinding::bind, R.layout.activity_korean), RestaurantListView {

    var RestaurantList = mutableListOf<restaurantList>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressON(context!!)
        val bzdCd = sSharedPreferences.getString("code",null)
        RestaurantListService(this).get_restaurant_list("6","0","1171011100")

        val size = sSharedPreferences.getInt("size", 0)

        for (i in 0..size) {
            val url_img = sSharedPreferences.getString("url_img${i}", null)
            val name = sSharedPreferences.getString("name${i}", null)
            val star = sSharedPreferences.getString("star${i}", null)
            val Cnt = sSharedPreferences.getString("Cnt${i}", null)
            val menu = sSharedPreferences.getString("menu${i}", null)
            val time = sSharedPreferences.getString("time${i}", null)
            val price = sSharedPreferences.getInt("price${i}", 0)
            val tip = sSharedPreferences.getInt("tip${i}", 0)

            RestaurantList.add(
                restaurantList(
                    "${url_img}",
                    "${name}", "${star}", "(${Cnt})", "${menu}", "${time}",
                    price, tip, i
                )
            )
        }

        val customAdapter = CustomAdapter2(activity as RestaurantListActivity, RestaurantList)
        binding.koreanRecyclerview.adapter = customAdapter

        val layout2 = LinearLayoutManager(activity as RestaurantListActivity)
        binding.koreanRecyclerview.layoutManager = layout2
        binding.koreanRecyclerview.setHasFixedSize(true)

        customAdapter.setItemClickListener(object : CustomAdapter2.ItemClickListener{
            override fun onClick(view: View, position: Int) {
                val item = RestaurantList[position]
                val preferencesEditor: SharedPreferences.Editor = sSharedPreferences.edit()
                preferencesEditor.putInt("storeId",position+1)
                preferencesEditor.apply()
            }
        })
    }

    override fun onGet_RestaurantList_Success(response: restaurantlistResonse) {
        progressOFF()
        if (response.isSuccess) {
            val preferencesEditor: SharedPreferences.Editor = sSharedPreferences.edit()
            val index = response.result.size - 1

            preferencesEditor.putInt("size", index)

            for(i in 0..index)
            {
                val url_img = "https://prod.wooa-bm.shop" + response.result[i].storeLogoUrl
                val id = response.result[i].storeId
                val name = response.result[i].storeNm
                val star = response.result[i].star.toString()
                val Cnt = response.result[i].reviewCnt
                val menu = response.result[i].reprsnMenu
                val time = response.result[i].diliverTime
                val price = response.result[i].minOrderPrice
                val tip = response.result[i].deliverTip

                preferencesEditor.putString("url_img${i}", url_img)
                preferencesEditor.putString("name${i}", name)
                preferencesEditor.putString("star${i}", star)
                preferencesEditor.putString("Cnt${i}", Cnt)
                preferencesEditor.putString("menu${i}", menu)
                preferencesEditor.putString("time${i}", time)
                preferencesEditor.putInt("price${i}", price)
                preferencesEditor.putInt("tip${i}", tip)
                preferencesEditor.apply()
            }
        }
    }

    override fun onGet_RestaurantList_Failure(message: String) {

    }
}