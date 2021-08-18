package com.example.softsquaredproject.src.signup

import com.example.softsquaredproject.src.signup.models.EmailCheckResponse
import com.example.softsquaredproject.src.signup.models.PostEmailCheckRequest
import com.example.softsquaredproject.src.signup.models.PostSignUpRequest
import com.example.softsquaredproject.src.signup.models.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Signup2RetrofitInterface{
    @POST("/app/sign-up/email/check")
    fun emailcheck(@Body params: PostEmailCheckRequest): Call<EmailCheckResponse>

    @POST("/app/sign-up")
    fun signup(@Body params: PostSignUpRequest): Call<SignUpResponse>
}