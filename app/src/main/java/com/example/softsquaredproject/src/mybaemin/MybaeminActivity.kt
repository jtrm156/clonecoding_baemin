package com.example.softsquaredproject.src.mybaemin

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.config.ApplicationClass.Companion.sSharedPreferences
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivityMybaeminBinding
import com.example.softsquaredproject.src.home.HomeActivity
import com.example.softsquaredproject.src.login.LoginActivity
import com.example.softsquaredproject.src.start.StartActivity


class MybaeminActivity : BaseActivity<ActivityMybaeminBinding>(ActivityMybaeminBinding::inflate,TransitionMode.HORIZON) {

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_in_right, R.anim.none)
        super.onCreate(savedInstanceState)

        binding.mybaeminBarBack.setOnClickListener(){
            finish()
        }

        binding.mybaeminLogin.setOnClickListener(){
            startActivity(Intent(this, LoginActivity::class.java))
        }

        val jwt = sSharedPreferences.getString("jwt",null)
        val nickNm = sSharedPreferences.getString("nickNm",null)

        if(jwt != null){
            binding.mybaeminText1.text = "귀하신 분 ${nickNm}"
        }
    }

    override fun finish(){
        super.finish()

        overridePendingTransition(R.anim.none, R.anim.slide_out_right)
    }
}