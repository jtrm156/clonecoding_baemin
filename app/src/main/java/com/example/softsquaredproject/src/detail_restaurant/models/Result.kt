package com.example.softsquaredproject.src.detail_restaurant.models

data class Result(
    val commentCnt: Int,
    val deliverTime: String,
    val isKeep: String,
    val keepCnt: Int,
    val maxDeliverTip: Int,
    val minDeliverTip: Int,
    val minOrderPrice: Int,
    val paymentWay: String,
    val reviewCnt: Int,
    val star: Double,
    val storeBannerUrl: List<String>,
    val storeId: Int,
    val storeNm: String
)