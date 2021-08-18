package com.example.softsquaredproject.src.signup.models

import com.google.gson.annotations.SerializedName

data class ResultSignUp(
    @SerializedName("userId") val userId: String,
    @SerializedName("email") val email: String,
)