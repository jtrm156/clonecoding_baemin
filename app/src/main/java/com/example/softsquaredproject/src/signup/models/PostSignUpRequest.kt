package com.example.softsquaredproject.src.signup.models

import com.google.gson.annotations.SerializedName

data class PostSignUpRequest(
    @SerializedName("phoneNum") val phoneNum: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("nickNm") val nickNm: String,
    @SerializedName("birthDay") val birthDay: String,
)