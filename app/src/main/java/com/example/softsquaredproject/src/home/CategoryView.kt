package com.example.softsquaredproject.src.home

import com.example.softsquaredproject.src.detail_restaurant.models.DetailResponse
import com.example.softsquaredproject.src.home.models.CategoryResponse

interface CategoryView {

    fun onGet_main_Success(response : CategoryResponse)

    fun onGet_main_Failure(message: String)
}