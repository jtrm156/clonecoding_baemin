package com.example.softsquaredproject.src.payment

import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.src.mybaemin.MybaeminRetrofitInterface
import com.example.softsquaredproject.src.mybaemin.models.UserResponse
import com.example.softsquaredproject.src.payment.models.orderRequest
import com.example.softsquaredproject.src.payment.models.ordersuccessResponse
import com.example.softsquaredproject.src.payment.models.paymentwayResponse
import com.example.softsquaredproject.src.payment.models.phoneResponse
import com.example.softsquaredproject.src.signup.Signup2RetrofitInterface
import com.example.softsquaredproject.src.signup.models.EmailCheckResponse
import com.example.softsquaredproject.src.signup.models.PostEmailCheckRequest
import com.example.softsquaredproject.src.signup.models.PostSignUpRequest
import com.example.softsquaredproject.src.signup.models.SignUpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class paymentService(val view: paymentView) {
    fun order(OrderRequest: orderRequest){
        val SignupRetrofitInterface = ApplicationClass.sRetrofit.create(paymentRetrofitInterface::class.java)
        with(SignupRetrofitInterface) {
            order(OrderRequest).enqueue(object :
                Callback<ordersuccessResponse> {
                override fun onResponse(call: Call<ordersuccessResponse>, response: Response<ordersuccessResponse>) {
                    view.onPost_order_Success(response.body() as ordersuccessResponse)
                }

                override fun onFailure(call: Call<ordersuccessResponse>, t: Throwable) {
                    view.onPost_order_Failure(t.message ?: "통신 오류")
                }
            })
        }
    }

    fun payment(){
        val SignupRetrofitInterface = ApplicationClass.sRetrofit.create(paymentRetrofitInterface::class.java)
        SignupRetrofitInterface.payment().enqueue(object :
            Callback<paymentwayResponse> {
            override fun onResponse(call: Call<paymentwayResponse>, response: Response<paymentwayResponse>) {
                view.onPost_payment_way_Success(response.body() as paymentwayResponse)
            }

            override fun onFailure(call: Call<paymentwayResponse>, t: Throwable) {
                view.onPost_payment_way_Failure(t.message ?: "통신 오류")
            }
        })
    }

    fun phone(){
        val mybaeminRetrofitInterface = ApplicationClass.sRetrofit.create(paymentRetrofitInterface::class.java)
        mybaeminRetrofitInterface.phone().enqueue(object :
            Callback<phoneResponse> {
            override fun onResponse(call: Call<phoneResponse>, response: Response<phoneResponse>) {
                view.onGet_phone_Success(response.body() as phoneResponse)
            }

            override fun onFailure(call: Call<phoneResponse>, t: Throwable) {
                view.onGet_phone_Failure(t.message ?: "통신 오류")
            }
        })
    }
}