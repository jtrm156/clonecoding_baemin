package com.example.softsquaredproject.src.home

import com.example.softsquaredproject.src.home.models.CategoryResponse
import retrofit2.Call
import retrofit2.http.GET

interface CategoryRetrofitInterface {
    @GET("/app/main/delivery")
    fun get_main_list(
    ) : Call<CategoryResponse>
}