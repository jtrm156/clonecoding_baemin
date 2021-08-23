package com.example.softsquaredproject.src.order

import com.example.softsquaredproject.src.order.models.restaurantlistResonse

interface RestaurantListView {

    fun onGet_RestaurantList_Success(response : restaurantlistResonse)

    fun onGet_RestaurantList_Failure(message: String)
}