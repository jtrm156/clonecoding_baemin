package com.example.softsquaredproject.src.signup

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.config.ApplicationClass.Companion.sSharedPreferences
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivitySignupBinding
import com.example.softsquaredproject.src.signup.models.PhoneCheckResponse
import com.example.softsquaredproject.src.signup.models.PhoneSendResponse
import com.example.softsquaredproject.src.signup.models.PostPhoneCheckRequest
import com.example.softsquaredproject.src.signup.models.PostPhoneSendRequest

class SignupActivity : BaseActivity<ActivitySignupBinding>(ActivitySignupBinding::inflate, TransitionMode.HORIZON), SignupActivityView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.signupBarBack.setOnClickListener(){
            onBackPressed()
        }

        binding.signupGetNumber.setOnClickListener {
            val phoneNum = binding.signupEdtTxt1.text.toString()
            val postPhoneSendRequest = PostPhoneSendRequest(phoneNum = phoneNum)
            showLoadingDialog(this!!)
            SignupService(this).phonesend(postPhoneSendRequest)
            val preferencesEditor: SharedPreferences.Editor = sSharedPreferences.edit()
            preferencesEditor.putString("phoneNum",phoneNum)
            preferencesEditor.apply()
        }

        binding.signupNext.setOnClickListener(){

            binding.signupNext.setTextColor(Color.parseColor("#FF000000"))
            val phoneNum = binding.signupEdtTxt1.text.toString()
            val certNumCheck = binding.signupEdtTxt2.text.toString()
            val postPhoneCheckRequest = PostPhoneCheckRequest(phoneNum = phoneNum, certNumCheck = certNumCheck)
            showLoadingDialog(this!!)
            SignupService(this).phonecheck(postPhoneCheckRequest)
        }
    }

    override fun onPostPhoneSendSuccess(response: PhoneSendResponse) {
        dismissLoadingDialog()
        binding.signupGetNumberTxt.setTextColor(Color.parseColor("#FF000000"))
        binding.signupTxt2.visibility = View.VISIBLE
        binding.signupTxt3.visibility = View.VISIBLE
        binding.signupEdtTxt2.visibility = View.VISIBLE
    }

    override fun onPostPhoneSendFailure(message: String) {

    }

    override fun onPostPhoneCheckSuccess(response: PhoneCheckResponse) {
        dismissLoadingDialog()
        startActivity(Intent(this, Signup2Activity::class.java))
    }

    override fun onPostPhoneCheckFailure(message: String) {

    }
}