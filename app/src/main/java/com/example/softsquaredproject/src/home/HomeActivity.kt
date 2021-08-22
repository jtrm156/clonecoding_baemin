package com.example.softsquaredproject.src.home

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivityHomeBinding
import com.example.softsquaredproject.src.mybaemin.MybaeminActivity
import com.example.softsquaredproject.src.order.OrderFragment
import com.example.softsquaredproject.src.search_address.SearchadActivity
import com.example.softsquaredproject.src.start.StartActivity

data class Foodcategory(val img : Int, val category_name : String)

class HomeActivity : BaseActivity<ActivityHomeBinding>(ActivityHomeBinding::inflate,TransitionMode.HORIZON) {
    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_in_right, R.anim.none)
        super.onCreate(savedInstanceState)

        val address = ApplicationClass.sSharedPreferences.getString("jibun_address", null)
        val address2 = ApplicationClass.sSharedPreferences.getString("final_address", null)

        binding.homeAddress.text = "${address},${address2}"

        binding.homeBarBack.setOnClickListener(){
            onBackPressed()
        }
        binding.homeBarLinear.setOnClickListener(){
            startActivity(Intent(this, SearchadActivity::class.java))
        }
        binding.btmNavSearch.setOnClickListener(){
            startActivity(Intent(this, StartActivity::class.java))
        }
        binding.btmNavHeart.setOnClickListener(){
            startActivity(Intent(this, StartActivity::class.java))
        }
        binding.btmNavHome.setOnClickListener(){
            onBackPressed()
        }
        binding.btmNavOrderList.setOnClickListener(){
            startActivity(Intent(this, StartActivity::class.java))
        }
        binding.btmNavMyBaemin.setOnClickListener(){
            startActivity(Intent(this, MybaeminActivity::class.java))
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.home_fragment, HomeFragment())
            .commitAllowingStateLoss()

    }
    override fun finish(){
        super.finish()

        overridePendingTransition(R.anim.none, R.anim.slide_out_right)
    }
}