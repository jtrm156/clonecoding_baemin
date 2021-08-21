package com.example.softsquaredproject.src.order

import android.os.Bundle
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivityRestaurantListBinding
import com.example.softsquaredproject.databinding.FragmentOrderBinding

class RestaurantListActivity : BaseActivity<ActivityRestaurantListBinding>(
    ActivityRestaurantListBinding::inflate, TransitionMode.HORIZON) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        overridePendingTransition(R.anim.slide_in_right, R.anim.none)

        binding.orderBack.setOnClickListener(){
            finish()
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, OrderFragment())
            .commitAllowingStateLoss()
    }

    override fun finish(){
        super.finish()

        overridePendingTransition(R.anim.none, R.anim.slide_out_right)
    }
}