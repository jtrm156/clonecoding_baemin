package com.example.softsquaredproject.src.signup

import android.content.Intent
import android.os.Bundle
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivitySignupBinding
import com.example.softsquaredproject.src.home.HomeActivity

class SignupActivity : BaseActivity<ActivitySignupBinding>(ActivitySignupBinding::inflate, TransitionMode.HORIZON) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.signupNext.setOnClickListener(){
            startActivity(Intent(this, Signup2Activity::class.java))
        }
        binding.signupBarBack.setOnClickListener(){
            onBackPressed()
        }
    }
}