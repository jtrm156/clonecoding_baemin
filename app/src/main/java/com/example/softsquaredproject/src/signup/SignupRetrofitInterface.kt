package com.example.softsquaredproject.src.signup

import com.example.softsquaredproject.src.main.home.models.PostSignUpRequest
import com.example.softsquaredproject.src.main.home.models.SignUpResponse
import com.example.softsquaredproject.src.main.home.models.UserResponse
import com.example.softsquaredproject.src.signup.models.PhoneCheckResponse
import com.example.softsquaredproject.src.signup.models.PhoneSendResponse
import com.example.softsquaredproject.src.signup.models.PostPhoneCheckRequest
import com.example.softsquaredproject.src.signup.models.PostPhoneSendRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SignupRetrofitInterface{
    @POST("/app/sign-up/sms/send")
    fun phonesend(@Body params: PostPhoneSendRequest): Call<PhoneSendResponse>

    @POST("/app/sign-up/sms/check")
    fun phonecheck(@Body params: PostPhoneCheckRequest): Call<PhoneCheckResponse>
}