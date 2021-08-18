package com.example.softsquaredproject.src.login

import com.example.softsquaredproject.src.login.models.LoginResponse

interface LoginActivityView {
    fun onPostLoginSuccess(response: LoginResponse)

    fun onPostLoginFailure(message: String)
}