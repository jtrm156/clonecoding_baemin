package com.example.softsquaredproject.src.signup.models

import com.example.softsquaredproject.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class PhoneSendResponse(
    //@SerializedName("isSuccess") val isSuccess: Boolean = false,
    //@SerializedName("code") val code: Int = 0,
    //@SerializedName("message") val message: String? = null,
    @SerializedName("result") val result: ResultPhoneSend
) : BaseResponse()