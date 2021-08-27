package com.example.softsquaredproject.src.orderlist

import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.src.order.RestaurantListRetrofitInterface
import com.example.softsquaredproject.src.order.models.restaurantlistResonse
import com.example.softsquaredproject.src.orderlist.model.OrderListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OrderListService(val view : OrderListView) {

    fun get_order_list(){
        val orderListRetrofitInterface = ApplicationClass.sRetrofit.create(
            OrderListRetrofitInterface::class.java)
        orderListRetrofitInterface.get_order_list().enqueue(object :
            Callback<OrderListResponse> {
            override fun onResponse(call: Call<OrderListResponse>, response: Response<OrderListResponse>) {
                view.onGet_Order_List_Success(response.body() as OrderListResponse)
            }

            override fun onFailure(call: Call<OrderListResponse>, t: Throwable) {
                view.onGet_Order_List_Failure(t.message ?: "통신 오류")
            }
        })
    }

}