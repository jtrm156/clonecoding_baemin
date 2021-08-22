package com.example.softsquaredproject.src.order

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.BaseFragment
import com.example.softsquaredproject.databinding.ActivityKoreanBinding
import com.example.softsquaredproject.databinding.FragmentOrderBinding
import com.example.softsquaredproject.src.home.CustomAdapter
import com.example.softsquaredproject.src.home.Foodcategory
import com.example.softsquaredproject.src.home.HomeActivity


data class restaurantList(val img : Int,
                          val restaurant_name : String,
                          val restaurant_star : String,
                          val restaurant_reviewCnt : String,
                          val restaurant_menu : String,
                          val restaurant_delivertime : String,
                          val restaurant_orderprice : String,
                          val restaurant_delivertip : String
                          )

class KoreanFragment: BaseFragment<ActivityKoreanBinding>(ActivityKoreanBinding::bind, R.layout.activity_korean) {

    var RestaurantList = mutableListOf<restaurantList>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for(i in 0 .. 10) {
            RestaurantList.add(
                restaurantList(
                    R.drawable.baemin_category_icon1,
                    "더 진국 보정점", "4.9", "(100+)", "수육국밥,순대국밥", "49~64분",
                    "8000원", "0원~3500원"
                )
            )
            RestaurantList.add(
                restaurantList(
                    R.drawable.baemin_category_icon2,
                    "더 진국 보정점", "4.9", "(100+)", "수육국밥,순대국밥", "49~64분",
                    "8000원", "0원~3500원"
                )
            )
            RestaurantList.add(
                restaurantList(
                    R.drawable.baemin_category_icon3,
                    "더 진국 보정점", "4.9", "(100+)", "수육국밥,순대국밥", "49~64분",
                    "8000원", "0원~3500원"
                )
            )
            RestaurantList.add(
                restaurantList(
                    R.drawable.baemin_category_icon4,
                    "더 진국 보정점", "4.9", "(100+)", "수육국밥,순대국밥", "49~64분",
                    "8000원", "0원~3500원"
                )
            )
            RestaurantList.add(
                restaurantList(
                    R.drawable.baemin_category_icon5,
                    "더 진국 보정점", "4.9", "(100+)", "수육국밥,순대국밥", "49~64분",
                    "8000원", "0원~3500원"
                )
            )
        }

        val customAdapter = CustomAdapter2(activity as RestaurantListActivity, RestaurantList)
        binding.koreanRecyclerview.adapter = customAdapter

        /*
        val dividerItemDecoration =
            DividerItemDecoration(binding.koreanRecyclerview.context, LinearLayoutManager(activity as RestaurantListActivity).orientation)

        binding.koreanRecyclerview.addItemDecoration(dividerItemDecoration)
        */
        val layout2 = LinearLayoutManager(activity as RestaurantListActivity)
        binding.koreanRecyclerview.layoutManager = layout2
        binding.koreanRecyclerview.setHasFixedSize(true)

        customAdapter.setItemClickListener(object : CustomAdapter2.ItemClickListener{
            override fun onClick(view: View, position: Int) {
                val item = RestaurantList[position]
            }
        })
    }
}