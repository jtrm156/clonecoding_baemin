package com.example.softsquaredproject.src.signup.models

import com.example.softsquaredproject.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class EmailCheckResponse(
    @SerializedName("result") val result: ResultEmailCheck
) : BaseResponse()