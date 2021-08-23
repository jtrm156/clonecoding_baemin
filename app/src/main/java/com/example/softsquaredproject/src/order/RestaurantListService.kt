package com.example.softsquaredproject.src.order

import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.src.map.MapRetrofitInterface
import com.example.softsquaredproject.src.map.models.MapResponse
import com.example.softsquaredproject.src.order.models.restaurantlistResonse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestaurantListService(val view: RestaurantListView) {

    fun get_restaurant_list(category: String,
                    sort: String,
                    bzdCd: String){
        val restaurantlistRetrofitInterface = ApplicationClass.sRetrofit.create(RestaurantListRetrofitInterface::class.java)
        restaurantlistRetrofitInterface.get_restaurant_list(category,sort,bzdCd).enqueue(object :
            Callback<restaurantlistResonse> {
            override fun onResponse(call: Call<restaurantlistResonse>, response: Response<restaurantlistResonse>) {
                view.onGet_RestaurantList_Success(response.body() as restaurantlistResonse)
            }

            override fun onFailure(call: Call<restaurantlistResonse>, t: Throwable) {
                view.onGet_RestaurantList_Failure(t.message ?: "통신 오류")
            }
        })
    }

}