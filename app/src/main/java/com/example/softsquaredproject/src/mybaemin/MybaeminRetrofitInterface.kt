package com.example.softsquaredproject.src.mybaemin

import com.example.softsquaredproject.src.map.models2.MapResponse2
import com.example.softsquaredproject.src.mybaemin.models.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MybaeminRetrofitInterface {
    @GET("/app/users/mypage")
    @Headers("X-ACCESS-TOKEN:eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWQiOjksImlhdCI6MTYyOTkyMDkyMSwiZXhwIjoxNjMxMzkyMTUwfQ.9VIOiYCgzH-8uAxflRGClrhrK-y0IJ5DY7Df8b-wWNo")
    fun get_mypage(
    ) : Call<UserResponse>
}