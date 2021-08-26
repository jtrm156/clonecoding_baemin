package com.example.softsquaredproject.src.payment

import com.example.softsquaredproject.src.payment.models.orderRequest
import com.example.softsquaredproject.src.payment.models.ordersuccessResponse
import com.example.softsquaredproject.src.payment.models.paymentwayResponse
import com.example.softsquaredproject.src.payment.models.phoneResponse
import com.example.softsquaredproject.src.signup.models.EmailCheckResponse
import com.example.softsquaredproject.src.signup.models.PostEmailCheckRequest
import com.example.softsquaredproject.src.signup.models.PostSignUpRequest
import com.example.softsquaredproject.src.signup.models.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface paymentRetrofitInterface {
    @POST("/app/orders")
    fun order(@Body params: orderRequest): Call<ordersuccessResponse>

    @GET("/app/orders/pay")
    fun payment(
    ): Call<paymentwayResponse>

    @GET("/app/users/phone")
    @Headers("X-ACCESS-TOKEN:eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWQiOjksImlhdCI6MTYyOTkyMDkyMSwiZXhwIjoxNjMxMzkyMTUwfQ.9VIOiYCgzH-8uAxflRGClrhrK-y0IJ5DY7Df8b-wWNo")
    fun phone(
    ): Call<phoneResponse>
}