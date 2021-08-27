package com.example.softsquaredproject.src.orderlist

import com.example.softsquaredproject.src.order.models.restaurantlistResonse
import com.example.softsquaredproject.src.orderlist.model.OrderListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface OrderListRetrofitInterface {

    @GET("/app/orders")
    @Headers("X-ACCESS-TOKEN:eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWQiOjksImlhdCI6MTYyOTkyMDkyMSwiZXhwIjoxNjMxMzkyMTUwfQ.9VIOiYCgzH-8uAxflRGClrhrK-y0IJ5DY7Df8b-wWNo")
    fun get_order_list(
    ) : Call<OrderListResponse>
}