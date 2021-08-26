package com.example.softsquaredproject.src.map.models3

data class SearchAddressResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
)