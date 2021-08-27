package com.example.softsquaredproject.src.orderlist

import com.example.softsquaredproject.src.order.models.restaurantlistResonse
import com.example.softsquaredproject.src.orderlist.model.OrderListResponse

interface OrderListView {
    fun onGet_Order_List_Success(response : OrderListResponse)

    fun onGet_Order_List_Failure(message: String)
}