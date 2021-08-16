package com.example.softsquaredproject.src.signup

import android.content.Intent
import android.os.Bundle
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivitySignup2Binding
import com.example.softsquaredproject.databinding.ActivitySignupBinding
import com.example.softsquaredproject.src.home.HomeActivity

class Signup2Activity : BaseActivity<ActivitySignup2Binding>(ActivitySignup2Binding::inflate, TransitionMode.HORIZON) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.signup2Finish.setOnClickListener(){
            startActivity(Intent(this, HomeActivity::class.java))
        }
        binding.signup2BarBack.setOnClickListener(){
            onBackPressed()
        }
    }
}