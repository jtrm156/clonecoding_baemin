package com.example.softsquaredproject.src.signup.models

import com.google.gson.annotations.SerializedName

data class PostPhoneCheckRequest(
    @SerializedName("phoneNum") val phoneNum: String,
    @SerializedName("certNumCheck") val certNumCheck: String
)