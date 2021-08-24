package com.example.softsquaredproject.src.detail_restaurant.models

data class StoreBizHour(
    val bizHourId: Int,
    val bizHourNm: String,
    val closeTime: String,
    val startTime: String,
    val storeId: Int
)