package com.example.softsquaredproject.src.map.models2

data class MapResponse2(
    val addresses: List<Addresse>,
    val errorMessage: String,
    val meta: Meta,
    val status: String
)