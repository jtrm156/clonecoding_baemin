package com.example.softsquaredproject.src.login.models

import com.example.softsquaredproject.config.BaseResponse
import com.example.softsquaredproject.src.signup.models.ResultEmailCheck
import com.google.gson.annotations.SerializedName

data class PostLoginRequest(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)