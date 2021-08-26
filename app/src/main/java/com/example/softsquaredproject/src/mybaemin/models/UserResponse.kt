package com.example.softsquaredproject.src.mybaemin.models

data class UserResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
)