package com.example.softsquaredproject.src.detail_restaurant

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.config.ApplicationClass.Companion.sSharedPreferences
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivityDetailRestaurantListBinding
import com.example.softsquaredproject.src.basket.BasketActivity
import com.example.softsquaredproject.src.detail_restaurant.models.*
import com.example.softsquaredproject.src.map.Map2Activity
import com.google.android.material.tabs.TabLayout


class DetailActivity : BaseActivity<ActivityDetailRestaurantListBinding>(ActivityDetailRestaurantListBinding::inflate,TransitionMode.HORIZON), DetailView {

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_in_right, R.anim.none)
        super.onCreate(savedInstanceState)

        val storeId = sSharedPreferences.getInt("storeId", 0)

        DetailService(this).get_Detail_info_list(storeId)
        supportFragmentManager.beginTransaction().add(R.id.detail_pager, FragmentDeliveryOrder()).commit();

        binding.detailFab.setOnClickListener(){
            startActivity(Intent(this, BasketActivity::class.java))
        }
        binding.detailBarBack.setOnClickListener(){
            finish()
        }

        binding.detailTabLayout.addTab(binding.detailTabLayout.newTab().setText("배달주문"))
        binding.detailTabLayout.addTab(binding.detailTabLayout.newTab().setText("포장/방문주문"))

        binding.detailTabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val position = tab!!.position
                var selected: Fragment? = null
                if (position == 0) selected = FragmentDeliveryOrder() else if (position == 1) selected =
                    FragmentPackingOrder()
                supportFragmentManager.beginTransaction().replace(R.id.detail_pager, selected!!).commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

        supportFragmentManager.beginTransaction()
        .replace(R.id.detail_fragment2, FragmentMenu())
        .commitAllowingStateLoss()
    }

    override fun onGet_detail_info_Success(response: DetailResponse) {
        if(response.isSuccess){
            val preferencesEditor: SharedPreferences.Editor = sSharedPreferences.edit()
            binding.detailTxt1.text = response.result.storeNm
            binding.detailTxt2.text = response.result.storeNm


            if(response.result.storeBannerUrl.size == 0){
                binding.detailImg.setImageResource(0)
                binding.detailImg.visibility = View.GONE
            }
            else{
                val url_img = response.result.storeBannerUrl[0]
                Glide.with(this).load(url_img).override(400, 400).into(binding.detailImg)
            }
            binding.textView3.text = "${response.result.star}"
            binding.textView1.text = "최근리뷰 "+"${response.result.reviewCnt}"
            binding.textView2.text = "최근사장님댓글 "+"${response.result.commentCnt}"
            binding.textView5.text = "찜"+"${response.result.keepCnt}"

            preferencesEditor.putInt("minPrice",response.result.minOrderPrice)
            preferencesEditor.putString("paymentWay",response.result.paymentWay)
            preferencesEditor.putString("deliverTime",response.result.deliverTime)
            preferencesEditor.putInt("minDeliverTip",response.result.minDeliverTip)
            preferencesEditor.putInt("maxDeliverTip",response.result.maxDeliverTip)
            preferencesEditor.putString("isKeep",response.result.isKeep)
            preferencesEditor.apply()
        }
    }

    override fun onGet_detail_info_Failure(message: String) {

    }

    override fun onGet_info_Success(response: InfoResponse) {

    }

    override fun onGet_info_Failure(message: String) {

    }

    override fun onGet_menu_Success(response: MenuResponse) {

    }

    override fun onGet_menu_Failure(message: String) {

    }

    override fun onGet_review_info_Success(response: ReviewInfoResponse) {
        TODO("Not yet implemented")
    }

    override fun onGet_review_info_Failure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onGet_review_list_Success(response: ReviewListResponse) {
        TODO("Not yet implemented")
    }

    override fun onGet_review_list_Failure(message: String) {
        TODO("Not yet implemented")
    }

    override fun finish(){
        super.finish()

        overridePendingTransition(R.anim.none, R.anim.slide_out_right)
    }
}