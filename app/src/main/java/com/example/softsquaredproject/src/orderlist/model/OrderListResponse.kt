package com.example.softsquaredproject.src.orderlist.model

data class OrderListResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
)