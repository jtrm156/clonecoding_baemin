package com.example.softsquaredproject.src.order.models

data class Result(
    val deliverTip: Int,
    val diliverTime: String,
    val minOrderPrice: Int,
    val reprsnMenu: String,
    val reviewCnt: String,
    val star: Double,
    val storeId: Int,
    val storeLogoUrl: String,
    val storeNm: String
)