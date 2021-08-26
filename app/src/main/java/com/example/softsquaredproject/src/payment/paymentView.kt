package com.example.softsquaredproject.src.payment

import com.example.softsquaredproject.src.payment.models.ordersuccessResponse
import com.example.softsquaredproject.src.payment.models.paymentwayResponse
import com.example.softsquaredproject.src.payment.models.phoneResponse
import com.example.softsquaredproject.src.signup.models.EmailCheckResponse
import com.example.softsquaredproject.src.signup.models.SignUpResponse

interface paymentView {
    fun onPost_order_Success(response: ordersuccessResponse)

    fun onPost_order_Failure(message: String)

    fun onPost_payment_way_Success(response: paymentwayResponse)

    fun onPost_payment_way_Failure(message: String)

    fun onGet_phone_Success(response: phoneResponse)

    fun onGet_phone_Failure(message: String)
}