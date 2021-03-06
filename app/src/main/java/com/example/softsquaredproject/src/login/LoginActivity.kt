package com.example.softsquaredproject.src.login

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivityLoginBinding
import com.example.softsquaredproject.src.login.models.LoginResponse
import com.example.softsquaredproject.src.login.models.PostLoginRequest
import com.example.softsquaredproject.src.mybaemin.MybaeminActivity
import com.example.softsquaredproject.src.mybaemin.MybaeminService
import com.example.softsquaredproject.src.mybaemin.models.UserResponse
import com.example.softsquaredproject.src.signup.SignupActivity
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.AuthErrorCause
import com.kakao.sdk.user.UserApiClient

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate,TransitionMode.HORIZON), LoginActivityView{

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_in_right, R.anim.none)
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
            progressON()
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
        progressOFF()
        if(response.isSuccess){
            startActivity(Intent(this, MybaeminActivity::class.java))
            showCustomToast("로그인되었습니다.")
            LoginService(this).get_mypage()
            val preferencesEditor: SharedPreferences.Editor = ApplicationClass.sSharedPreferences.edit()
            preferencesEditor.putString("jwt", response.result.jwt)
            preferencesEditor.apply()
            finish()
        }
        else if(response.isSuccess == false){
            binding.loginText3.visibility = View.VISIBLE
            binding.loginText4.visibility = View.VISIBLE
        }
    }

    override fun onPostLoginFailure(message: String) {

    }

    override fun onGet_mypage_Success(response: UserResponse) {
        if(response.isSuccess){
            val preferencesEditor: SharedPreferences.Editor = ApplicationClass.sSharedPreferences.edit()
            preferencesEditor.putString("user_nickNm", response.result.nickNm)
            preferencesEditor.apply()
        }
    }

    override fun onGet_mypage_Failure(message: String) {

    }

    override fun onDestroy(){
        super.onDestroy()
        /*
        UserApiClient.instance.logout { error ->
            if (error != null) {
                Toast.makeText(this, "로그아웃 실패 $error", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this, "로그아웃 성공", Toast.LENGTH_SHORT).show()
            }
        }

        UserApiClient.instance.unlink { error ->
            if (error != null) {
                Toast.makeText(this, "회원탈퇴 실패 $error", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this, "회원탈퇴 성공", Toast.LENGTH_SHORT).show()
            }
        }
        */
    }

    override fun finish(){
        super.finish()

        overridePendingTransition(R.anim.none, R.anim.slide_out_right)
    }
}