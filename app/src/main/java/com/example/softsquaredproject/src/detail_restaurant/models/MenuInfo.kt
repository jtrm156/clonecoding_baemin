package com.example.softsquaredproject.src.detail_restaurant.models

data class MenuInfo(
    val isHot: String,
    val isReprsnMenu: String,
    val isSoldOut: String,
    val menuId: Int,
    val menuImgUrl: String,
    val menuInfo: String,
    val menuNm: String,
    val price: Int
)