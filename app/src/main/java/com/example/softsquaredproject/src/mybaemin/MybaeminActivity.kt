package com.example.softsquaredproject.src.mybaemin

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.config.ApplicationClass.Companion.sSharedPreferences
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivityMybaeminBinding
import com.example.softsquaredproject.src.home.HomeActivity
import com.example.softsquaredproject.src.login.LoginActivity
import com.example.softsquaredproject.src.mybaemin.models.UserResponse
import com.example.softsquaredproject.src.start.StartActivity


class MybaeminActivity : BaseActivity<ActivityMybaeminBinding>(ActivityMybaeminBinding::inflate,TransitionMode.HORIZON), MybaeminView {

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_in_right, R.anim.none)
        super.onCreate(savedInstanceState)

        val nickNm = sSharedPreferences.getString("user_nickNm",null)

        binding.mybaeminBarBack.setOnClickListener(){
            finish()
        }

        binding.mybaeminLogin.setOnClickListener(){
            startActivity(Intent(this, LoginActivity::class.java))
        }

        val jwt = sSharedPreferences.getString("jwt",null)

        if(jwt != null){
            binding.mybaeminText1.text = "더 귀한 분,"
            binding.mybaeminBanner.visibility = View.GONE
            binding.mybaeminGrade.visibility = View.VISIBLE
            binding.mybaeminText0.visibility = View.VISIBLE
            binding.mybaeminText0.text = nickNm
        }
        else{
            binding.mybaeminBanner.visibility = View.VISIBLE
            binding.mybaeminGrade.visibility = View.GONE
        }
    }

    override fun finish(){
        super.finish()

        overridePendingTransition(R.anim.none, R.anim.slide_out_right)
    }

    override fun onGet_mypage_Success(response: UserResponse) {
        if(response.isSuccess){
            binding.mybaeminText0.text = response.result.nickNm
        }
    }

    override fun onGet_mypage_Failure(message: String) {
    }
}