package com.example.softsquaredproject.src.payment

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.ApplicationClass.Companion.sSharedPreferences
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivityPaymentBinding
import com.example.softsquaredproject.src.home.HomeActivity
import com.example.softsquaredproject.src.payment.models.*

class PaymentActivity : BaseActivity<ActivityPaymentBinding>(ActivityPaymentBinding::inflate), paymentView{
    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_in_right, R.anim.none)
        super.onCreate(savedInstanceState)

        orderMenu(1,2,listOf(menuOption(1,2)))

        binding.basketCheck1.isChecked = true
        binding.basketCheck4.isChecked = true
        binding.map2Txt1.text = sSharedPreferences.getString("jibun_address",null)
        binding.map2Txt3.text = sSharedPreferences.getString("road_address",null)
        binding.searchEdt1.setText("${sSharedPreferences.getString("final_address",null)}")

        val deliverytip = 3000

        binding.paymentConstraint13Txt4.text = "${sSharedPreferences.getInt("item_price",0)}원"
        binding.paymentConstraint13Txt8.text = "${sSharedPreferences.getInt("item_price",0)+deliverytip}원"
        binding.basketTxt6.text = "${sSharedPreferences.getInt("item_price",0)+deliverytip}원 결제하기"
        paymentService(this).phone()

        binding.paymentConstraint6Linear1.setOnClickListener(){
            val intent = Intent(this, PaymentWayActivity::class.java)
            startActivity(intent)
        }

        binding.paymentConstraint6Linear1Txt1.setOnClickListener(){
            val intent = Intent(this, PaymentWayActivity::class.java)
            startActivity(intent)
        }
        val secondIntent = intent

        if("${secondIntent.getStringExtra("answer")}" == "null"){
            binding.searchEdt4.setText("신용/체크카드")
        }

        binding.searchEdt4.setText("${secondIntent.getStringExtra("answer")}")

        binding.basketConstraint4.setOnClickListener(){
            paymentService(this).order(orderRequest(4,1,"${binding.searchEdt2.text}",
                "천천히 와주세요","KAKAO", deliverytip,
                "${sSharedPreferences.getString("road_address",null)}","${sSharedPreferences.getString("jibun_address",null)}",
                "${sSharedPreferences.getString("pay_phoneNum",null)}", listOf(orderMenu(1,2,listOf(menuOption(1,2))))))
        }
    }

    override fun finish(){
        super.finish()

        overridePendingTransition(R.anim.none, R.anim.slide_out_right)
    }

    override fun onPost_order_Success(response: ordersuccessResponse) {
        if(response.isSuccess){
            showCustomToast("주문되었습니다")
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onPost_order_Failure(message: String) {

    }

    override fun onPost_payment_way_Success(response: paymentwayResponse) {

    }

    override fun onPost_payment_way_Failure(message: String) {

    }

    override fun onGet_phone_Success(response: phoneResponse) {
        if(response.isSuccess) {
            binding.paymentTxt2.text = response.result.phoneNum

            val preferencesEditor: SharedPreferences.Editor = sSharedPreferences.edit()
            preferencesEditor.putString("pay_phoneNum", response.result.phoneNum)
            preferencesEditor.putInt("pay_userid", response.result.userId)
            preferencesEditor.apply()
        }
    }

    override fun onGet_phone_Failure(message: String) {

    }
}