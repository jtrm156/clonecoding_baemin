package com.example.softsquaredproject.src.signup

import androidx.constraintlayout.widget.ConstraintLayout
import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.src.main.home.models.SignUpResponse
import com.example.softsquaredproject.src.main.home.models.UserResponse
import com.example.softsquaredproject.src.signup.models.PhoneCheckResponse
import com.example.softsquaredproject.src.signup.models.PhoneSendResponse
import com.example.softsquaredproject.src.signup.models.PostPhoneCheckRequest
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

    fun phonecheck(postPhoneCheckRequest: PostPhoneCheckRequest){
        val Signup2RetrofitInterface = ApplicationClass.sRetrofit.create(SignupRetrofitInterface::class.java)
        Signup2RetrofitInterface.phonecheck(postPhoneCheckRequest).enqueue(object :
            Callback<PhoneCheckResponse> {
            override fun onResponse(call: Call<PhoneCheckResponse>, response: Response<PhoneCheckResponse>) {
                view.onPostPhoneCheckSuccess(response.body() as PhoneCheckResponse)
            }

            override fun onFailure(call: Call<PhoneCheckResponse>, t: Throwable) {
                view.onPostPhoneCheckFailure(t.message ?: "통신 오류")
            }
        })
    }
}