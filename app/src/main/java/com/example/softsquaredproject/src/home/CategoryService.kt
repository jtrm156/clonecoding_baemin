package com.example.softsquaredproject.src.home

import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.src.home.models.CategoryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryService(val view: CategoryView) {
    fun get_main_list(
    ){
        val CategoryRetrofitInterface = ApplicationClass.sRetrofit.create(
            CategoryRetrofitInterface::class.java)
        CategoryRetrofitInterface.get_main_list().enqueue(object :
            Callback<CategoryResponse> {
            override fun onResponse(call: Call<CategoryResponse>, response: Response<CategoryResponse>) {
                view.onGet_main_Success(response.body() as CategoryResponse)
            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                view.onGet_main_Failure(t.message ?: "통신 오류")
            }
        })
    }
}