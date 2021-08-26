package com.example.softsquaredproject.src.mybaemin

import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.src.map.MapRetrofitInterface
import com.example.softsquaredproject.src.map.models.MapResponse
import com.example.softsquaredproject.src.mybaemin.models.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MybaeminService(val view: MybaeminView) {
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