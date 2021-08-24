package com.example.softsquaredproject.src.detail_restaurant.models

data class InfoResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: ResultX
)