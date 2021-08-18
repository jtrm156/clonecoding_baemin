package com.example.softsquaredproject.src.signup.models

import com.google.gson.annotations.SerializedName

data class ResultPhoneSend(
    @SerializedName("phoneNum") val phoneNum: String,
    @SerializedName("certNum") val certNum: String
)