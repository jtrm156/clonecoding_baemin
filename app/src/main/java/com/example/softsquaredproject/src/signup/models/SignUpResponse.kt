package com.example.softsquaredproject.src.signup.models

import com.example.softsquaredproject.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("result") val result: ResultSignUp
) : BaseResponse()