package com.example.softsquaredproject.src.mybaemin

import android.content.Intent
import android.os.Bundle
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivityMybaeminBinding
import com.example.softsquaredproject.src.home.HomeActivity
import com.example.softsquaredproject.src.login.LoginActivity
import com.example.softsquaredproject.src.start.StartActivity


class MybaeminActivity : BaseActivity<ActivityMybaeminBinding>(ActivityMybaeminBinding::inflate,TransitionMode.HORIZON) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.mybaeminBarBack.setOnClickListener(){
            finish()
        }

        binding.mybaeminLogin.setOnClickListener(){
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}