package com.example.softsquaredproject.src.home

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.config.ApplicationClass.Companion.sSharedPreferences
import com.example.softsquaredproject.config.BaseFragment
import com.example.softsquaredproject.databinding.FragmentDeliveryBinding
import com.example.softsquaredproject.src.home.models.CategoryResponse
import com.example.softsquaredproject.src.mybaemin.MybaeminActivity
import com.example.softsquaredproject.src.search_address.SearchadActivity
import com.example.softsquaredproject.src.start.StartActivity

class DeliveryFragment : BaseFragment<FragmentDeliveryBinding>(FragmentDeliveryBinding::bind, R.layout.fragment_delivery), CategoryView{

    var FoodcategoryList = mutableListOf<Foodcategory>()

    private fun getbannerlist(): ArrayList<Int> {

        return arrayListOf<Int>(R.drawable.baemin_banner1, R.drawable.baemin_banner2, R.drawable.baemin_banner3,
            R.drawable.baemin_banner4,R.drawable.baemin_banner5,R.drawable.baemin_banner6,R.drawable.baemin_banner7,R.drawable.baemin_banner8)
    }

    private var myHandler = MyHandler()

    private val intervalTime = 1500.toLong()

    var currentPosition = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressON(context!!)
        CategoryService(this).get_main_list()

        for(i in 0..0) {
            FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon1, "${sSharedPreferences.getString("categoryNm${i}",null)}"))
            FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon2, "${sSharedPreferences.getString("categoryNm${i+1}",null)}"))
            FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon3, "${sSharedPreferences.getString("categoryNm${i+2}",null)}"))
            FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon4, "${sSharedPreferences.getString("categoryNm${i+3}",null)}"))
            FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon5, "${sSharedPreferences.getString("categoryNm${i+4}",null)}"))
            FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon6, "${sSharedPreferences.getString("categoryNm${i+5}",null)}"))
            FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon7, "${sSharedPreferences.getString("categoryNm${i+6}",null)}"))
            FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon8, "${sSharedPreferences.getString("categoryNm${i+7}",null)}"))
            FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon9, "${sSharedPreferences.getString("categoryNm${i+8}",null)}"))
            FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon10, "${sSharedPreferences.getString("categoryNm${i+9}",null)}"))
            FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon11, "${sSharedPreferences.getString("categoryNm${i+10}",null)}"))
            FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon12, "${sSharedPreferences.getString("categoryNm${i+11}",null)}"))
            FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon13, "${sSharedPreferences.getString("categoryNm${i+12}",null)}"))
            FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon14, "${sSharedPreferences.getString("categoryNm${i+13}",null)}"))
            FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon15, "${sSharedPreferences.getString("categoryNm${i+14}",null)}"))
            FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon16, "${sSharedPreferences.getString("categoryNm${i+15}",null)}"))
            FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon17, ""))
            FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon17, ""))
            FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon17, ""))
            FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon17, ""))
        }
        val customAdapter = CustomAdapter(activity as HomeActivity, FoodcategoryList)
        binding.homeFoodcategory.adapter = customAdapter

        val layout2 = GridLayoutManager(activity as HomeActivity,5)
        layout2.orientation = LinearLayoutManager.VERTICAL
        binding.homeFoodcategory.layoutManager = layout2
        binding.homeFoodcategory.setHasFixedSize(true)

        customAdapter.setItemClickListener(object : CustomAdapter.ItemClickListener{
            override fun onClick(view: View, position: Int) {
                val item = FoodcategoryList[position]
                val preferencesEditor: SharedPreferences.Editor = sSharedPreferences.edit()
                preferencesEditor.putInt("Foodcategory", position)
                preferencesEditor.apply()
            }
        })
        binding.homeViewpager.adapter = ViewPagerAdapter(getbannerlist())
        binding.homeViewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        changePageNumber()
    }

    fun changePageNumber(){
        binding.homeViewpager.apply {
            registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.textViewCurrentBanner.text = "${(position%8)+1}"
                    currentPosition = position
                }

                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                    when (state) {
                        // ?????????????????? ??? ???????????? / ???????????? ???????????? ???
                        ViewPager2.SCROLL_STATE_IDLE -> autoScrollStart(intervalTime)
                        // ???????????? ???????????? ???
                        ViewPager2.SCROLL_STATE_DRAGGING -> autoScrollStop()
                    }
                }
            })
        }
    }

    private fun autoScrollStart(intervalTime: Long) {
        myHandler.removeMessages(0) // ?????? ????????? ???????????? 1???, 2???, 3??? ... n??? ?????? ?????? ?????????
        myHandler.sendEmptyMessageDelayed(0, intervalTime) // intervalTime ?????? ???????????? ???????????? ???????????? ???
    }

    private fun autoScrollStop(){
        myHandler.removeMessages(0) // ???????????? ????????????
    }

    private inner class MyHandler : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            if(msg.what == 0) {
                binding.homeViewpager.setCurrentItem(++currentPosition, true) // ?????? ???????????? ??????
                autoScrollStart(intervalTime) // ???????????? ?????? ????????? ??????.
            }
        }
    }

    // ?????? ????????? ????????? ???????????? ?????? ????????? ??????
    override fun onResume() {
        super.onResume()
        autoScrollStart(intervalTime)
    }

    // ?????? ???????????? ???????????? ?????? ???????????? ????????? ????????? ??????. ??????
    override fun onPause() {
        super.onPause()
        autoScrollStop()
    }

    override fun onGet_main_Success(response: CategoryResponse) {
        progressOFF()
        if(response.isSuccess){
            val preferencesEditor: SharedPreferences.Editor = sSharedPreferences.edit()
            val index = response.result.size - 1

            for(i in 0 .. index){
                preferencesEditor.putString("categoryNm${i}", response.result[i].categoryNm)
                preferencesEditor.apply()
            }
        }
    }

    override fun onGet_main_Failure(message: String) {

    }
}