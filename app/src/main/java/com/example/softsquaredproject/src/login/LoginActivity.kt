package com.example.softsquaredproject.src.login

import android.content.Intent
import android.os.Bundle
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivityLoginBinding
import com.example.softsquaredproject.src.login.models.LoginResponse
import com.example.softsquaredproject.src.login.models.PostLoginRequest
import com.example.softsquaredproject.src.mybaemin.MybaeminActivity
import com.example.softsquaredproject.src.signup.SignupActivity
import com.example.softsquaredproject.src.signup.SignupService
import com.example.softsquaredproject.src.signup.models.PostPhoneSendRequest

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate,TransitionMode.HORIZON), LoginActivityView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.loginSignup.setOnClickListener(){
            startActivity(Intent(this, SignupActivity::class.java))
        }
        binding.loginBarBack.setOnClickListener(){
            onBackPressed()
        }
        binding.loginButton.setOnClickListener(){
            val email = binding.loginEdtTxt1.text.toString()
            val password = binding.loginEdtTxt2.text.toString()
            val postLoginRequest = PostLoginRequest(email = email, password = password)
            showLoadingDialog(this!!)
            LoginService(this).login(postLoginRequest)
        }
    }

    override fun onPostLoginSuccess(response: LoginResponse) {
        dismissLoadingDialog()
        if(response.isSuccess){
            startActivity(Intent(this, MybaeminActivity::class.java))
            showCustomToast("로그인되었습니다.")
        }
    }

    override fun onPostLoginFailure(message: String) {

    }
}