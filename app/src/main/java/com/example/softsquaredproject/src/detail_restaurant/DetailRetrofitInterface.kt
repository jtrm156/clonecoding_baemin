package com.example.softsquaredproject.src.detail_restaurant

import com.example.softsquaredproject.src.detail_restaurant.models.DetailResponse
import com.example.softsquaredproject.src.detail_restaurant.models.InfoResponse
import com.example.softsquaredproject.src.detail_restaurant.models.MenuResponse
import com.example.softsquaredproject.src.order.models.restaurantlistResonse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DetailRetrofitInterface {

    @GET("/app/stores/{storeId}")
    fun get_detail_info_list(
        @Path("storeId") storeId: Int
    ) : Call<DetailResponse>

    @GET("/app/stores/{storeId}/info")
    fun get_info_list(
        @Path("storeId") storeId: Int
    ) : Call<InfoResponse>

    @GET("/app/stores/{storeId}/menu")
    fun get_menu_list(
        @Path("storeId") storeId: Int
    ) : Call<MenuResponse>
}