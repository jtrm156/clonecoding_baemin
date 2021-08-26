package com.example.softsquaredproject.src.payment

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import com.example.softsquaredproject.config.ApplicationClass.Companion.sSharedPreferences
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivityPaymentwayBinding
import com.example.softsquaredproject.src.login.LoginActivity
import com.example.softsquaredproject.src.payment.models.ordersuccessResponse
import com.example.softsquaredproject.src.payment.models.paymentwayResponse
import com.example.softsquaredproject.src.payment.models.phoneResponse

class PaymentWayActivity : BaseActivity<ActivityPaymentwayBinding>(ActivityPaymentwayBinding::inflate), paymentView{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        paymentService(this).payment()

        binding.paymentwayBarBack.setOnClickListener(){
            finish()
        }

        binding.paymentwayConstraint1.setOnClickListener(){
            binding.paymentwayConstraint1Img1.visibility = View.VISIBLE
            binding.paymentwayConstraint2Img1.visibility = View.GONE
            binding.paymentwayConstraint3Img1.visibility = View.GONE
            binding.paymentwayConstraint4Img1.visibility = View.GONE
            binding.paymentwayConstraint5Img1.visibility = View.GONE

            val intent = Intent(this, PaymentActivity::class.java)
            intent.putExtra("answer", binding.paymentConstraint1Txt1.text)
            startActivity(intent)
        }
        binding.paymentwayConstraint2.setOnClickListener(){
            binding.paymentwayConstraint1Img1.visibility = View.GONE
            binding.paymentwayConstraint2Img1.visibility = View.VISIBLE
            binding.paymentwayConstraint3Img1.visibility = View.GONE
            binding.paymentwayConstraint4Img1.visibility = View.GONE
            binding.paymentwayConstraint5Img1.visibility = View.GONE
            val intent = Intent(this, PaymentActivity::class.java)
            intent.putExtra("answer", binding.paymentConstraint2Txt1.text)
            startActivity(intent)
        }
        binding.paymentwayConstraint3.setOnClickListener(){
            binding.paymentwayConstraint1Img1.visibility = View.GONE
            binding.paymentwayConstraint2Img1.visibility = View.GONE
            binding.paymentwayConstraint3Img1.visibility = View.VISIBLE
            binding.paymentwayConstraint4Img1.visibility = View.GONE
            binding.paymentwayConstraint5Img1.visibility = View.GONE
            val intent = Intent(this, PaymentActivity::class.java)
            intent.putExtra("answer", binding.paymentConstraint3Txt1.text)
            startActivity(intent)
        }
        binding.paymentwayConstraint4.setOnClickListener(){
            binding.paymentwayConstraint1Img1.visibility = View.GONE
            binding.paymentwayConstraint2Img1.visibility = View.GONE
            binding.paymentwayConstraint3Img1.visibility = View.GONE
            binding.paymentwayConstraint4Img1.visibility = View.VISIBLE
            binding.paymentwayConstraint5Img1.visibility = View.GONE
            val intent = Intent(this, PaymentActivity::class.java)
            intent.putExtra("answer", binding.paymentConstraint4Txt1.text)
            startActivity(intent)
        }
        binding.paymentwayConstraint5.setOnClickListener(){
            binding.paymentwayConstraint1Img1.visibility = View.GONE
            binding.paymentwayConstraint2Img1.visibility = View.GONE
            binding.paymentwayConstraint3Img1.visibility = View.GONE
            binding.paymentwayConstraint4Img1.visibility = View.GONE
            binding.paymentwayConstraint5Img1.visibility = View.VISIBLE
            val intent = Intent(this, PaymentActivity::class.java)
            intent.putExtra("answer", binding.paymentConstraint5Txt1.text)
            startActivity(intent)
        }
    }

    override fun onPost_order_Success(response: ordersuccessResponse) {

    }

    override fun onPost_order_Failure(message: String) {

    }

    override fun onPost_payment_way_Success(response: paymentwayResponse) {
        if(response.isSuccess){
            val index = response.result.size

            for(i in 0 .. index-1){
                binding.paymentConstraint1Txt1.text = response.result[0].paymentNm
                binding.paymentConstraint2Txt1.text = response.result[1].paymentNm
                binding.paymentConstraint3Txt1.text = response.result[2].paymentNm
                binding.paymentConstraint4Txt1.text = response.result[3].paymentNm
                binding.paymentConstraint5Txt1.text = response.result[4].paymentNm
                binding.paymentConstraint6Txt1.text = response.result[5].paymentNm
                binding.paymentConstraint7Txt1.text = response.result[6].paymentNm

                val preferencesEditor: SharedPreferences.Editor = sSharedPreferences.edit()
                preferencesEditor.putString("paymentCd${i}", response.result[i].paymentCd)
                preferencesEditor.apply()
            }
        }
    }

    override fun onPost_payment_way_Failure(message: String) {

    }

    override fun onGet_phone_Success(response: phoneResponse) {

    }

    override fun onGet_phone_Failure(message: String) {

    }
}