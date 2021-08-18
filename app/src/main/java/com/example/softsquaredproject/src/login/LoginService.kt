package com.example.softsquaredproject.src.login

import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.src.login.models.LoginResponse
import com.example.softsquaredproject.src.login.models.PostLoginRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService(val view: LoginActivityView) {
    fun login(postLoginRequest: PostLoginRequest){
        val LoginRetrofitInterface = ApplicationClass.sRetrofit.create(LoginRetrofitInterface::class.java)
        LoginRetrofitInterface.login(postLoginRequest).enqueue(object :
            Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                view.onPostLoginSuccess(response.body() as LoginResponse)
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                view.onPostLoginFailure(t.message ?: "통신 오류")
            }
        })
    }
}