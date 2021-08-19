package com.example.softsquaredproject.src.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivityLoginBinding
import com.example.softsquaredproject.src.login.models.LoginResponse
import com.example.softsquaredproject.src.login.models.PostLoginRequest
import com.example.softsquaredproject.src.mybaemin.MybaeminActivity
import com.example.softsquaredproject.src.signup.SignupActivity
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.AuthErrorCause

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

        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                when {
                    error.toString() == AuthErrorCause.AccessDenied.toString() -> {
                        Toast.makeText(this, "접근이 거부 됨(동의 취소)", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.InvalidClient.toString() -> {
                        Toast.makeText(this, "유효하지 않은 앱", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.InvalidGrant.toString() -> {
                        Toast.makeText(this, "인증 수단이 유효하지 않아 인증할 수 없는 상태", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.InvalidRequest.toString() -> {
                        Toast.makeText(this, "요청 파라미터 오류", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.InvalidScope.toString() -> {
                        Toast.makeText(this, "유효하지 않은 scope ID", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.Misconfigured.toString() -> {
                        Toast.makeText(this, "설정이 올바르지 않음(android key hash)", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.ServerError.toString() -> {
                        Toast.makeText(this, "서버 내부 에러", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.Unauthorized.toString() -> {
                        Toast.makeText(this, "앱이 요청 권한이 없음", Toast.LENGTH_SHORT).show()
                    }
                    else -> { // Unknown
                        Toast.makeText(this, "기타 에러", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else if (token != null) {
                //Toast.makeText(this, "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show()
                var intent = Intent(this,MybaeminActivity::class.java)
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            }
        }
            binding.loginKakao.setOnClickListener {
                LoginClient.instance.run {
                    if (isKakaoTalkLoginAvailable(this@LoginActivity)) {
                        loginWithKakaoTalk(this@LoginActivity, callback = callback)
                    } else {
                        loginWithKakaoAccount(this@LoginActivity, callback = callback)
                    }
                }
            }
    }

    override fun onPostLoginSuccess(response: LoginResponse) {
        dismissLoadingDialog()
        if(response.isSuccess){
            startActivity(Intent(this, MybaeminActivity::class.java))
            showCustomToast("로그인되었습니다.")
        }
        else if(response.isSuccess == false){
            binding.loginText3.visibility = View.VISIBLE
            binding.loginText4.visibility = View.VISIBLE
        }
    }

    override fun onPostLoginFailure(message: String) {

    }
}