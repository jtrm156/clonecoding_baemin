package com.example.softsquaredproject.src.login

import com.example.softsquaredproject.src.login.models.LoginResponse
import com.example.softsquaredproject.src.login.models.PostLoginRequest
import com.example.softsquaredproject.src.mybaemin.models.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginRetrofitInterface {
    @POST("/app/login")
    fun login(@Body params: PostLoginRequest): Call<LoginResponse>

    @GET("/app/users/mypage")
    @Headers("X-ACCESS-TOKEN:eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWQiOjksImlhdCI6MTYyOTkyMDkyMSwiZXhwIjoxNjMxMzkyMTUwfQ.9VIOiYCgzH-8uAxflRGClrhrK-y0IJ5DY7Df8b-wWNo")
    fun get_mypage(
    ) : Call<UserResponse>
}