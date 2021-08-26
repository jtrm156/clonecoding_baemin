package com.example.softsquaredproject.src.map

import com.example.softsquaredproject.src.map.models.MapResponse
import com.example.softsquaredproject.src.map.models2.MapResponse2
import com.example.softsquaredproject.src.map.models3.SearchAddressResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface MapRetrofitInterface {
    @GET("map-reversegeocode/v2/gc")
    @Headers("X-NCP-APIGW-API-KEY-ID:dnpo0dr7bf","X-NCP-APIGW-API-KEY:v6BqYg48tI5xAdvfRU9wiXtphDzza3RTFWsBuP7U")
    fun gettrans_xy(
        @Query("coords") coords: String,
        @Query("output") output: String,
        @Query("orders") orders: String,
    ) : Call<MapResponse>

    @GET("map-geocode/v2/geocode")
    @Headers("X-NCP-APIGW-API-KEY-ID:dnpo0dr7bf","X-NCP-APIGW-API-KEY:v6BqYg48tI5xAdvfRU9wiXtphDzza3RTFWsBuP7U")
    fun gettrans_ad(
        @Query("query") query: String
    ) : Call<MapResponse2>

    @GET("/app/address")
    fun get_search_address_ad(
        @Query("pageIdx") pageIdx: Int,
        @Query("query") query: String
    ) : Call<SearchAddressResponse>
}