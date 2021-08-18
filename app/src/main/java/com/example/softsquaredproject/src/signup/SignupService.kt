package com.example.softsquaredproject.src.signup

import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.src.signup.models.PhoneSendResponse
import com.example.softsquaredproject.src.signup.models.PostPhoneSendRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupService(val view: SignupActivityView) {

    fun phonesend(postPhoneSendRequest: PostPhoneSendRequest){
        val SignupRetrofitInterface = ApplicationClass.sRetrofit.create(SignupRetrofitInterface::class.java)
        SignupRetrofitInterface.phonesend(postPhoneSendRequest).enqueue(object :
            Callback<PhoneSendResponse> {
            override fun onResponse(call: Call<PhoneSendResponse>, response: Response<PhoneSendResponse>) {
                view.onPostPhoneSendSuccess(response.body() as PhoneSendResponse)
            }

            override fun onFailure(call: Call<PhoneSendResponse>, t: Throwable) {
                view.onPostPhoneSendFailure(t.message ?: "통신 오류")
            }
        })
    }
}