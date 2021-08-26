package com.example.softsquaredproject.src.mybaemin

import com.example.softsquaredproject.src.map.models.MapResponse
import com.example.softsquaredproject.src.mybaemin.models.UserResponse

interface MybaeminView {
    fun onGet_mypage_Success(response : UserResponse)

    fun onGet_mypage_Failure(message: String)
}