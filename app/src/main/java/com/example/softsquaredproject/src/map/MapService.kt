package com.example.softsquaredproject.src.map

import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.src.map.models.MapResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Query

class MapService(val view: MapActivityView) {
    fun gettrans_xy(coords: String,
                    output: String,
                    orders: String){
        val mapRetrofitInterface = ApplicationClass.sRetrofit2.create(MapRetrofitInterface::class.java)
        mapRetrofitInterface.gettrans_xy(coords,output,orders).enqueue(object : Callback<MapResponse> {
            override fun onResponse(call: Call<MapResponse>, response: Response<MapResponse>) {
                view.onGettrans_xySuccess(response.body() as MapResponse)
            }

            override fun onFailure(call: Call<MapResponse>, t: Throwable) {
                view.onGettrans_xyFailure(t.message ?: "통신 오류")
            }
        })
    }
}