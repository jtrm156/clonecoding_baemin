package com.example.softsquaredproject.src.login

import com.example.softsquaredproject.src.login.models.LoginResponse
import com.example.softsquaredproject.src.login.models.PostLoginRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginRetrofitInterface {
    @POST("/app/login")
    fun login(@Body params: PostLoginRequest): Call<LoginResponse>
}