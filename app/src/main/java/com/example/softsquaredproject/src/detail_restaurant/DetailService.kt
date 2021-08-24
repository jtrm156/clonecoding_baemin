package com.example.softsquaredproject.src.detail_restaurant

import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.src.detail_restaurant.models.DetailResponse
import com.example.softsquaredproject.src.detail_restaurant.models.InfoResponse
import com.example.softsquaredproject.src.detail_restaurant.models.MenuResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailService(val view: DetailView) {
    fun get_Detail_info_list(
                            storeId: Int,
                            ){
        val DetailRetrofitInterface = ApplicationClass.sRetrofit.create(
            DetailRetrofitInterface::class.java)
        DetailRetrofitInterface.get_detail_info_list(storeId).enqueue(object :
            Callback<DetailResponse> {
            override fun onResponse(call: Call<DetailResponse>, response: Response<DetailResponse>) {
                view.onGet_detail_info_Success(response.body() as DetailResponse)
            }

            override fun onFailure(call: Call<DetailResponse>, t: Throwable) {
                view.onGet_detail_info_Failure(t.message ?: "통신 오류")
            }
        })
    }

    fun get_info_list(
        storeId: Int,
    ){
        val DetailRetrofitInterface = ApplicationClass.sRetrofit.create(
            DetailRetrofitInterface::class.java)
        DetailRetrofitInterface.get_info_list(storeId).enqueue(object :
            Callback<InfoResponse> {
            override fun onResponse(call: Call<InfoResponse>, response: Response<InfoResponse>) {
                view.onGet_info_Success(response.body() as InfoResponse)
            }

            override fun onFailure(call: Call<InfoResponse>, t: Throwable) {
                view.onGet_info_Failure(t.message ?: "통신 오류")
            }
        })
    }

    fun get_menu_list(
        storeId: Int,
    ){
        val DetailRetrofitInterface = ApplicationClass.sRetrofit.create(
            DetailRetrofitInterface::class.java)
        DetailRetrofitInterface.get_menu_list(storeId).enqueue(object :
            Callback<MenuResponse> {
            override fun onResponse(call: Call<MenuResponse>, response: Response<MenuResponse>) {
                view.onGet_menu_Success(response.body() as MenuResponse)
            }

            override fun onFailure(call: Call<MenuResponse>, t: Throwable) {
                view.onGet_menu_Failure(t.message ?: "통신 오류")
            }
        })
    }
}