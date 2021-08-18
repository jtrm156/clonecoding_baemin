package com.example.softsquaredproject.src.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivitySplashBinding
import com.example.softsquaredproject.src.start.StartActivity

class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, StartActivity::class.java))
            finish()
        }, 1500)
    }
}