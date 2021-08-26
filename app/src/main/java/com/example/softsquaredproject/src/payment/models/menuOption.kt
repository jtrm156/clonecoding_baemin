package com.example.softsquaredproject.src.payment.models

import com.google.gson.annotations.SerializedName

data class menuOption(
    @SerializedName("optGrpId") val optGrpId: Int,
    @SerializedName("optId") val optId: Int
)
