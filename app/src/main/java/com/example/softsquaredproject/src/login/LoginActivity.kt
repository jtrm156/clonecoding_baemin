package com.example.softsquaredproject.src.login

import android.content.Intent
import android.os.Bundle
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivityLoginBinding
import com.example.softsquaredproject.src.signup.SignupActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate,TransitionMode.HORIZON) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.loginSignup.setOnClickListener(){
            startActivity(Intent(this, SignupActivity::class.java))
        }
        binding.loginBarBack.setOnClickListener(){
            onBackPressed()
        }
    }
}