package com.example.softsquaredproject.src.start

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import android.view.Window
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivityStartBinding
import com.example.softsquaredproject.src.home.HomeActivity
import com.example.softsquaredproject.src.main.MainActivity
import com.example.softsquaredproject.src.mybaemin.MybaeminActivity

class StartActivity : BaseActivity<ActivityStartBinding>(ActivityStartBinding::inflate,TransitionMode.HORIZON) {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

            binding.startDelivery.setOnClickListener() {
                startActivity(Intent(this, HomeActivity::class.java))
            }
            binding.startBarImage2.setOnClickListener(){
                startActivity(Intent(this, MybaeminActivity::class.java))
            }
    }
}