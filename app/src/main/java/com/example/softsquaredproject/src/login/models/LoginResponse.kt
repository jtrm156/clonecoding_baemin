package com.example.softsquaredproject.src.login.models

import com.example.softsquaredproject.config.BaseResponse
import com.example.softsquaredproject.src.signup.models.ResultEmailCheck
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("result") val result: ResultLogin
) : BaseResponse()