package com.example.softsquaredproject.src.signup.models

import com.google.gson.annotations.SerializedName

data class ResultPhoneCheck(
    @SerializedName("phoneNum") val phoneNum: String
)