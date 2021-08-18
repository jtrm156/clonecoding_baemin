package com.example.softsquaredproject.src.signup.models

import com.google.gson.annotations.SerializedName

data class PostEmailCheckRequest(
    @SerializedName("email") val email: String
)