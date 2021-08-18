package com.example.softsquaredproject.src.signup

import com.example.softsquaredproject.src.signup.models.EmailCheckResponse
import com.example.softsquaredproject.src.signup.models.SignUpResponse

interface Signup2ActivityView {
    fun onPostEmailCheckSuccess(response: EmailCheckResponse)

    fun onPostEmailCheckFailure(message: String)

    fun onPostSignUpSuccess(response: SignUpResponse)

    fun onPostSignUpFailure(message: String)
}