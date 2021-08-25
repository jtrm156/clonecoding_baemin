package com.example.softsquaredproject.src.detail_restaurant

import com.example.softsquaredproject.src.detail_restaurant.models.*
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

    @GET("/app/stores/{storeId}/review")
    fun get_review_info_list(
        @Path("storeId") storeId: Int
    ) : Call<ReviewInfoResponse>

    @GET("/app/stores/{storeId}/reviews")
    fun get_review_list(
        @Path("storeId") storeId: Int,
        @Query("pageIdx") pageIdx: Int,
        @Query("sort") sort: Int
    ) : Call<ReviewListResponse>
}