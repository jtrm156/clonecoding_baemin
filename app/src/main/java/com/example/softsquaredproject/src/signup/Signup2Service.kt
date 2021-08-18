package com.example.softsquaredproject.src.signup

import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.src.signup.models.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Signup2Service(val view: Signup2ActivityView) {

    fun emailcheck(postEmailCheckRequest: PostEmailCheckRequest){
        val SignupRetrofitInterface = ApplicationClass.sRetrofit.create(Signup2RetrofitInterface::class.java)
        with(SignupRetrofitInterface) {
            emailcheck(postEmailCheckRequest).enqueue(object :
                Callback<EmailCheckResponse> {
                override fun onResponse(call: Call<EmailCheckResponse>, response: Response<EmailCheckResponse>) {
                    view.onPostEmailCheckSuccess(response.body() as EmailCheckResponse)
                }

                override fun onFailure(call: Call<EmailCheckResponse>, t: Throwable) {
                    view.onPostEmailCheckFailure(t.message ?: "통신 오류")
                }
            })
        }
    }

    fun signup(postSignUpRequest: PostSignUpRequest){
        val SignupRetrofitInterface = ApplicationClass.sRetrofit.create(Signup2RetrofitInterface::class.java)
        with(SignupRetrofitInterface) {
            signup(postSignUpRequest).enqueue(object :
                Callback<SignUpResponse> {
                override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
                    view.onPostSignUpSuccess(response.body() as SignUpResponse)
                }

                override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                    view.onPostSignUpFailure(t.message ?: "통신 오류")
                }
            })
        }
    }
}