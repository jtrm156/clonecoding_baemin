package com.example.softsquaredproject.src.signup

import com.example.softsquaredproject.src.signup.models.PhoneCheckResponse
import com.example.softsquaredproject.src.signup.models.PhoneSendResponse

interface SignupActivityView {

    fun onPostPhoneSendSuccess(response: PhoneSendResponse)

    fun onPostPhoneSendFailure(message: String)

    fun onPostPhoneCheckSuccess(response: PhoneCheckResponse)

    fun onPostPhoneCheckFailure(message: String)
}