package com.example.softsquaredproject.src.detail_restaurant.models

data class ResultX(
    val bizNm: String,
    val bizNum: String,
    val deliveryLocation: String,
    val deliveryTip: List<DeliveryTip>,
    val holiday: String,
    val keepCnt: Int,
    val orderCnt: String,
    val ownerNm: String,
    val reviewCnt: String,
    val storeAddr: String,
    val storeBizHour: List<StoreBizHour>,
    val storeId: Int,
    val storeInfo: String,
    val storeIntro: Any,
    val storeIntroImg: List<StoreIntroImg>,
    val storePhoneNum: String
)