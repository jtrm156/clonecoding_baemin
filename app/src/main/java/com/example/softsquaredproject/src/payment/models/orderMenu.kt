package com.example.softsquaredproject.src.payment.models

import com.google.gson.annotations.SerializedName

data class orderMenu(
    @SerializedName("menuId") val menuId: Int,
    @SerializedName("qty") val qty: Int,
    @SerializedName("menuOption") val menuOption: List<menuOption>,
)