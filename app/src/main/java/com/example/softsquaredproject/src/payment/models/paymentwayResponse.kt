package com.example.softsquaredproject.src.payment.models

data class paymentwayResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
)