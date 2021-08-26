package com.example.softsquaredproject.src.login

import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.src.login.models.LoginResponse
import com.example.softsquaredproject.src.login.models.PostLoginRequest
import com.example.softsquaredproject.src.mybaemin.MybaeminRetrofitInterface
import com.example.softsquaredproject.src.mybaemin.models.UserResponse
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

    fun get_mypage(){
        val mybaeminRetrofitInterface = ApplicationClass.sRetrofit.create(MybaeminRetrofitInterface::class.java)
        mybaeminRetrofitInterface.get_mypage().enqueue(object :
            Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                view.onGet_mypage_Success(response.body() as UserResponse)
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                view.onGet_mypage_Failure(t.message ?: "통신 오류")
            }
        })
    }
}