package com.example.softsquaredproject.src.detail_restaurant

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.config.ApplicationClass.Companion.sSharedPreferences
import com.example.softsquaredproject.config.BaseFragment
import com.example.softsquaredproject.databinding.FragmentMenu2Binding
import com.example.softsquaredproject.src.detail_restaurant.models.*
import com.example.softsquaredproject.src.order.CustomAdapter2
import com.example.softsquaredproject.src.order.RestaurantListActivity
import com.example.softsquaredproject.src.order.restaurantList

data class menuList(val menuGrpNm : String, val menuNm : String, val price : Int, val isReprsnMenu : String, val isSoldOut : String, val isHot : String, val menu_url_img : String)

class FragmentMenu2 : BaseFragment<FragmentMenu2Binding>(FragmentMenu2Binding::bind, R.layout.fragment_menu2), DetailView {

    var MenuList = mutableListOf<menuList>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val storeId = sSharedPreferences.getInt("storeId", 0)

        DetailService(this).get_menu_list(storeId)

        MenuList.add(menuList("대표메뉴","교촌발사믹치킨",19000, "N", "Y","Y","http://www.consumernews.co.kr/news/photo/202107/630060_224158_4140.jpg"))
        MenuList.add(menuList("신메뉴","교촌발사믹치킨",19000, "N", "Y","Y","http://www.consumernews.co.kr/news/photo/202107/630060_224158_4140.jpg"))
        MenuList.add(menuList("교촌시리즈","교촌콤보",17000, "Y", "Y","Y","http://www.kyochon.com/uploadFiles/TB_ITEM/%EB%B8%8C%EB%9E%9C%EB%93%9C_list_15-10-231103.png"))
        MenuList.add(menuList("레드시리즈","교촌레드콤보",18000, "N", "Y","Y","http://www.kyochon.com/uploadFiles/TB_ITEM/%EB%B8%8C%EB%9E%9C%EB%93%9C_list_15-10-231098.png"))
        MenuList.add(menuList("허니시리즈","교촌허니콤보",19900, "Y", "Y","Y","http://www.kyochon.com/uploadFiles/TB_ITEM/%EB%B8%8C%EB%9E%9C%EB%93%9C_list_%ED%97%88%EB%8B%88%EC%88%9C%EC%82%B4R(0).png"))
        MenuList.add(menuList("사이드메뉴","교촌웨지감자",5000, "N", "Y","Y","http://www.kyochon.com/uploadFiles/TB_ITEM/%EC%9B%A8%EC%A7%80%EA%B0%90%EC%9E%90_%EB%A6%AC%EC%8A%A4%ED%8A%B8.png"))
        val customAdapter = CustomAdapter3(activity as DetailActivity, MenuList)
        binding.menu2RecyclerView.adapter = customAdapter

        val layout2 = LinearLayoutManager(activity as DetailActivity)
        binding.menu2RecyclerView.layoutManager = layout2
        binding.menu2RecyclerView.setHasFixedSize(true)

        customAdapter.setItemClickListener(object : CustomAdapter3.ItemClickListener{
            override fun onClick(view: View, position: Int) {
                val item = MenuList[position]
            }
        })
    }

    override fun onGet_detail_info_Success(response: DetailResponse) {

    }

    override fun onGet_detail_info_Failure(message: String) {

    }

    override fun onGet_info_Success(response: InfoResponse) {

    }

    override fun onGet_info_Failure(message: String) {

    }

    override fun onGet_menu_Success(response: MenuResponse) {
        if(response.isSuccess){
            val preferencesEditor: SharedPreferences.Editor = sSharedPreferences.edit()
            //binding.detailTxt4.text = response.result.origin
            binding.menu2Txt2.text = response.result.storeInfo
            val index = response.result.groupInfo.size
            /*
            for(i in 0 .. index-1){
                val menuGrpNm = response.result.groupInfo[i].menuGrpNm
                val index2 = response.result.groupMenuInfo[index].menuInfo.size

                for(j in 0 ..index2-1) {
                    val menu_url_img = response.result.groupMenuInfo[i].menuInfo[j].menuImgUrl
                    val menuNm = response.result.groupMenuInfo[i].menuInfo[j].menuNm
                    val isReprsnMenu = response.result.groupMenuInfo[i].menuInfo[j].isReprsnMenu
                    val isSoldOut = response.result.groupMenuInfo[i].menuInfo[j].isSoldOut
                    val isHot = response.result.groupMenuInfo[i].menuInfo[j].isHot

                    preferencesEditor.putString("menu_url_img${i+j}", menu_url_img)
                    preferencesEditor.putString("menuNm${i+j}", menuNm)
                    preferencesEditor.putString("isReprsnMenu${i+j}", isReprsnMenu)
                    preferencesEditor.putString("isSoldOut${i+j}", isSoldOut)
                    preferencesEditor.putString("isHot${i+j}", isHot)
                    preferencesEditor.apply()
                }
                preferencesEditor.putString("menuGrpNm${i}", menuGrpNm)
            }

             */
        }
    }

    override fun onGet_menu_Failure(message: String) {

    }

    override fun onGet_review_info_Success(response: ReviewInfoResponse) {

    }

    override fun onGet_review_info_Failure(message: String) {

    }

    override fun onGet_review_list_Success(response: ReviewListResponse) {

    }

    override fun onGet_review_list_Failure(message: String) {

    }
}