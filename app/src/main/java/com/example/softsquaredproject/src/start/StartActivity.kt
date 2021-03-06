package com.example.softsquaredproject.src.start

import android.app.ActivityOptions
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.transition.Slide
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.animation.Animation
import android.view.animation.Transformation
import androidx.core.widget.NestedScrollView
import androidx.viewpager2.widget.ViewPager2
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.ApplicationClass.Companion.sSharedPreferences
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivityStartBinding
import com.example.softsquaredproject.src.home.CustomAdapter
import com.example.softsquaredproject.src.home.HomeActivity
import com.example.softsquaredproject.src.home.ViewPagerAdapter
import com.example.softsquaredproject.src.mybaemin.MybaeminActivity
import com.example.softsquaredproject.src.search_address.SearchadActivity

class StartActivity : BaseActivity<ActivityStartBinding>(ActivityStartBinding::inflate,TransitionMode.HORIZON) {

    private fun getbannerlist(): ArrayList<Int> {

        return arrayListOf<Int>(R.drawable.baemin_home_banner1, R.drawable.baemin_home_banner2, R.drawable.baemin_home_banner3, R.drawable.baemin_home_banner4)
    }

    var currentPosition = 0

    private var myHandler = MyHandler()

    private val intervalTime = 1500.toLong()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val address = sSharedPreferences.getString("jibun_address",null)
        val address2 = sSharedPreferences.getString("final_address",null)

        binding.startAddress.text = "${address},${address2}"

        binding.startDelivery.setOnClickListener() {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        binding.startBarImage2.setOnClickListener() {
            startActivity(Intent(this, MybaeminActivity::class.java))
        }
        binding.startBarLinear.setOnClickListener() {
            startActivity(Intent(this, SearchadActivity::class.java))
        }

        binding.startViewpager.adapter = ViewPagerAdapter(getbannerlist())
        binding.startViewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        changePageNumber()

        binding.ivArrow.setOnClickListener() {
            if (binding.llDetail.visibility == View.GONE) {
                binding.llDetail.expand(scrollView = binding.startNestedscroll)
                binding.ivArrow.setImageResource(R.drawable.icon_up)
            } else { //VISIBLE
                binding.llDetail.collapse()
                binding.ivArrow.setImageResource(R.drawable.icon_down2)
            }
        }
    }

    fun changePageNumber(){
        binding.startViewpager.apply {
            registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.textViewCurrentBanner.text = "${(position%4)+1}"
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
                binding.startViewpager.setCurrentItem(++currentPosition, true) // ?????? ???????????? ??????
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

    fun View.expand(scrollView: NestedScrollView?=null) {
        measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val actualHeight = measuredHeight
        layoutParams.height = 0
        visibility = View.VISIBLE
        val animation: Animation = object : Animation() {
            override fun applyTransformation(
                interpolatedTime: Float,
                t: Transformation
            ) {
                layoutParams.height =
                    if (interpolatedTime == 1f) ViewGroup.LayoutParams.WRAP_CONTENT else (actualHeight * interpolatedTime).toInt()
                requestLayout()
            }
        }
        /** REPEATING FOR VIDEO **/
        animation.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationRepeat(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                //set visible when animation ends
                scrollView?.run{
                    smoothScrollTo(0, bottom)
                }
            }

            override fun onAnimationStart(animation: Animation?) {
            }

        })
        animation.duration = (actualHeight / context.resources.displayMetrics.density).toLong()
        startAnimation(animation)
    }

    fun View.collapse() {
        val actualHeight: Int = measuredHeight
        val animation: Animation = object : Animation() {
            override fun applyTransformation(
                interpolatedTime: Float,
                t: Transformation?
            ) {
                if (interpolatedTime == 1f) {
                    visibility = View.GONE
                } else {
                    layoutParams.height =
                        actualHeight - (actualHeight * interpolatedTime).toInt()
                    requestLayout()
                }
            }
        }

        animation.duration =
            (actualHeight / context.resources.displayMetrics.density).toLong()
        startAnimation(animation)
    }
}