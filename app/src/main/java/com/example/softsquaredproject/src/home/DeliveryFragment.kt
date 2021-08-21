package com.example.softsquaredproject.src.home

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.BaseFragment
import com.example.softsquaredproject.databinding.FragmentDeliveryBinding
import com.example.softsquaredproject.src.mybaemin.MybaeminActivity
import com.example.softsquaredproject.src.search_address.SearchadActivity
import com.example.softsquaredproject.src.start.StartActivity

class DeliveryFragment : BaseFragment<FragmentDeliveryBinding>(FragmentDeliveryBinding::bind, R.layout.fragment_delivery){

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

        FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon1, "1인분"))
        FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon2, "한식"))
        FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon3, "분식"))
        FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon4, "카페·디저트"))
        FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon5, "돈까스·회·일식"))
        FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon6, "치킨"))
        FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon7, "피자"))
        FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon8, "아시안·양식"))
        FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon9, "중국집"))
        FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon10, "족발·보쌈"))
        FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon11, "야식"))
        FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon12, "찜·탕"))
        FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon13, "도시락"))
        FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon14, "패스트푸드"))
        FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon15, "브랜드관"))
        FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon16, "맛집랭킹"))
        FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon17, ""))
        FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon17, ""))
        FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon17, ""))
        FoodcategoryList.add(Foodcategory(R.drawable.baemin_category_icon17, ""))

        val customAdapter = CustomAdapter(activity as HomeActivity, FoodcategoryList)
        binding.homeFoodcategory.adapter = customAdapter

        val layout2 = GridLayoutManager(activity as HomeActivity,5)
        layout2.orientation = LinearLayoutManager.VERTICAL
        binding.homeFoodcategory.layoutManager = layout2
        binding.homeFoodcategory.setHasFixedSize(true)


        customAdapter.setItemClickListener(object : CustomAdapter.ItemClickListener{
            override fun onClick(view: View, position: Int) {
                val item = FoodcategoryList[position]
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
                        // 뷰페이저에서 손 떼었을때 / 뷰페이저 멈춰있을 때
                        ViewPager2.SCROLL_STATE_IDLE -> autoScrollStart(intervalTime)
                        // 뷰페이저 움직이는 중
                        ViewPager2.SCROLL_STATE_DRAGGING -> autoScrollStop()
                    }
                }
            })
        }
    }

    private fun autoScrollStart(intervalTime: Long) {
        myHandler.removeMessages(0) // 이거 안하면 핸들러가 1개, 2개, 3개 ... n개 만큼 계속 늘어남
        myHandler.sendEmptyMessageDelayed(0, intervalTime) // intervalTime 만큼 반복해서 핸들러를 실행하게 함
    }

    private fun autoScrollStop(){
        myHandler.removeMessages(0) // 핸들러를 중지시킴
    }

    private inner class MyHandler : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            if(msg.what == 0) {
                binding.homeViewpager.setCurrentItem(++currentPosition, true) // 다음 페이지로 이동
                autoScrollStart(intervalTime) // 스크롤을 계속 이어서 한다.
            }
        }
    }

    // 다른 페이지 갔다가 돌아오면 다시 스크롤 시작
    override fun onResume() {
        super.onResume()
        autoScrollStart(intervalTime)
    }

    // 다른 페이지로 떠나있는 동안 스크롤이 동작할 필요는 없음. 정지
    override fun onPause() {
        super.onPause()
        autoScrollStop()
    }
}