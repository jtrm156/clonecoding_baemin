package com.example.softsquaredproject.src.orderlist.model

data class Result(
    val isDelivered: String,
    val isPossibleReview: String,
    val orderId: Int,
    val orderMenu: String,
    val orderedAt: String,
    val storeId: Int,
    val storeLogoUrl: String,
    val storeNm: String,
    val totalPrice: Int
)