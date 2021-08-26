package com.example.softsquaredproject.src.payment.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class orderRequest(
    @SerializedName("userId") val userId: Int,
    @SerializedName("storeId") val storeId: Int,
    @SerializedName("storeReqCont") val storeReqCont: String,
    @SerializedName("ridderReqCont") val ridderReqCont: String,
    @SerializedName("paymentOp") val paymentOp: String,
    @SerializedName("deliveryTip") val deliveryTip: Int,
    @SerializedName("roadAddr") val roadAddr: String,
    @SerializedName("jibunAddr") val jibunAddr: String,
    @SerializedName("phoneNum") val phoneNum: String,
    @SerializedName("orderMenu") val orderMenu: List<orderMenu>
)