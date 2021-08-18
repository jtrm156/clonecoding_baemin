package com.example.softsquaredproject.src.signup

import com.example.softsquaredproject.src.signup.models.PhoneSendResponse
import com.example.softsquaredproject.src.signup.models.PostPhoneSendRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignupRetrofitInterface{
    @POST("/app/sign-up/sms/send")
    fun phonesend(@Body params: PostPhoneSendRequest): Call<PhoneSendResponse>
}