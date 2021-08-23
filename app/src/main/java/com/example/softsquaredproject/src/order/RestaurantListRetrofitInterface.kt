package com.example.softsquaredproject.src.order

import com.example.softsquaredproject.src.map.models.MapResponse
import com.example.softsquaredproject.src.order.models.restaurantlistResonse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RestaurantListRetrofitInterface {
    @GET("/app/stores")
    fun get_restaurant_list(
        @Query("category") category: String,
        @Query("sort") sort: String,
        @Query("bzdCd") bzdCd: String,
    ) : Call<restaurantlistResonse>
}