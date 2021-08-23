package com.example.softsquaredproject.src.order.models

data class restaurantlistResonse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
)