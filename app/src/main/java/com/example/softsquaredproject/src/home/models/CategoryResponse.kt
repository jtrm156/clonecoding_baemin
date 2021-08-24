package com.example.softsquaredproject.src.home.models

data class CategoryResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
)