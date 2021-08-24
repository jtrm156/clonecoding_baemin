package com.example.softsquaredproject.src.detail_restaurant

import com.example.softsquaredproject.src.detail_restaurant.models.DetailResponse
import com.example.softsquaredproject.src.detail_restaurant.models.InfoResponse
import com.example.softsquaredproject.src.detail_restaurant.models.MenuResponse
import com.example.softsquaredproject.src.order.models.restaurantlistResonse

interface DetailView {

    fun onGet_detail_info_Success(response : DetailResponse)

    fun onGet_detail_info_Failure(message: String)

    fun onGet_info_Success(response : InfoResponse)

    fun onGet_info_Failure(message: String)

    fun onGet_menu_Success(response : MenuResponse)

    fun onGet_menu_Failure(message: String)

}