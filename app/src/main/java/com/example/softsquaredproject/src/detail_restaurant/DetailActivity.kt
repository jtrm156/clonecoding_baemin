package com.example.softsquaredproject.src.detail_restaurant

import android.os.Bundle
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivityDetailRestaurantListBinding

class DetailActivity : BaseActivity<ActivityDetailRestaurantListBinding>(ActivityDetailRestaurantListBinding::inflate,TransitionMode.HORIZON) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}