package com.example.softsquaredproject.src.login

import com.example.softsquaredproject.src.login.models.LoginResponse
import com.example.softsquaredproject.src.mybaemin.models.UserResponse

interface LoginActivityView {
    fun onPostLoginSuccess(response: LoginResponse)

    fun onPostLoginFailure(message: String)

    fun onGet_mypage_Success(response : UserResponse)

    fun onGet_mypage_Failure(message: String)
}