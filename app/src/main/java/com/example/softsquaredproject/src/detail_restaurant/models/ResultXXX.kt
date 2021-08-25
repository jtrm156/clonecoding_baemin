package com.example.softsquaredproject.src.detail_restaurant.models

data class ResultXXX(
    val ownerOneWord: String,
    val point1: Int,
    val point2: Int,
    val point3: Int,
    val point4: Int,
    val point5: Int,
    val reviewInfo: String,
    val reviewInfoImg: List<ReviewInfoImg>,
    val star: Double,
    val storeId: Int
)