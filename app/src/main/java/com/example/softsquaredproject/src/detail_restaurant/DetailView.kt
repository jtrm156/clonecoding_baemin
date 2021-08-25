package com.example.softsquaredproject.src.detail_restaurant

import com.example.softsquaredproject.src.detail_restaurant.models.*
import com.example.softsquaredproject.src.order.models.restaurantlistResonse

interface DetailView {

    fun onGet_detail_info_Success(response : DetailResponse)

    fun onGet_detail_info_Failure(message: String)

    fun onGet_info_Success(response : InfoResponse)

    fun onGet_info_Failure(message: String)

    fun onGet_menu_Success(response : MenuResponse)

    fun onGet_menu_Failure(message: String)

    fun onGet_review_info_Success(response: ReviewInfoResponse)

    fun onGet_review_info_Failure(message: String)

    fun onGet_review_list_Success(response: ReviewListResponse)

    fun onGet_review_list_Failure(message: String)
}