package com.example.softsquaredproject.src.detail_restaurant.models

data class DetailResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
)