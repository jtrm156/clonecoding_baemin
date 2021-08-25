package com.example.softsquaredproject.src.detail_restaurant.models

data class Review(
    val commentCont: Any,
    val createdAt: String,
    val nickNm: String,
    val orderId: Int,
    val orderMenuInfo: List<OrderMenuInfo>,
    val reviewCont: String,
    val reviewId: Int,
    val reviewImgUrl: Any,
    val star: Int,
    val storeId: Int,
    val userId: Int
)