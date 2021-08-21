package com.example.softsquaredproject.src.order

import android.os.Bundle
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivityRestaurantListBinding
import com.example.softsquaredproject.databinding.FragmentOrderBinding

class RestaurantListActivity : BaseActivity<FragmentOrderBinding>(
    FragmentOrderBinding::inflate, TransitionMode.HORIZON) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
            .replace(R.id.order_pager, KoreanFragment())
            .commit()
    }
}