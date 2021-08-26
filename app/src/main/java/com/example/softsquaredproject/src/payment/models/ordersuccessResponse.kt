package com.example.softsquaredproject.src.payment.models

data class ordersuccessResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: ResultX
)