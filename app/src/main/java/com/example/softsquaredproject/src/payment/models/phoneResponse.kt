package com.example.softsquaredproject.src.payment.models

data class phoneResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: ResultXX
)