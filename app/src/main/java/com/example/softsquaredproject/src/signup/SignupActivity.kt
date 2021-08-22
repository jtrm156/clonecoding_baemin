package com.example.softsquaredproject.src.signup

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.ApplicationClass.Companion.sSharedPreferences
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivitySignupBinding
import com.example.softsquaredproject.src.signup.models.PhoneSendResponse
import com.example.softsquaredproject.src.signup.models.PostPhoneSendRequest
import com.example.softsquaredproject.src.start.StartActivity

class SignupActivity : BaseActivity<ActivitySignupBinding>(ActivitySignupBinding::inflate, TransitionMode.HORIZON), SignupActivityView {

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_in_right, R.anim.none)
        super.onCreate(savedInstanceState)

        binding.signupEdtTxt1.addTextChangedListener((object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if(p0!!.length > 0 && p0!!.length <10) {
                    binding.signupEdtIcon2.setImageResource(R.drawable.icon_cancel)
                    binding.signupEdtIcon2.visibility = View.VISIBLE
                    binding.signupEdtIcon1.visibility = View.GONE
                    binding.signupGetNumberTxt.setTextColor(Color.parseColor("#878787"))
                }
                else if(p0!!.length >= 10 && p0!!.length < 12) {
                    binding.signupEdtIcon2.setImageResource(R.drawable.icon_check)
                    binding.signupEdtIcon1.visibility = View.VISIBLE
                    binding.signupGetNumberTxt.setTextColor(Color.parseColor("#FF000000"))
                }
                else{
                    binding.signupEdtIcon1.visibility = View.GONE
                    binding.signupEdtIcon2.visibility = View.GONE
                }
            }
        }))
        /*
        binding.signupEdtTxt1.setOnKeyListener(View.OnKeyListener(){
            fun onKey(View v, int keyCode, KeyEvent event): Boolean {
                if(keyCode==event.KEYCODE_ENTER) return true
                return false
            }
        })
        */
        binding.signupEdtTxt2.addTextChangedListener((object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if(p0!!.length > 0 && p0!!.length <4) {
                    binding.signupEdtIcon4.setImageResource(R.drawable.icon_cancel)
                    binding.signupEdtIcon4.visibility = View.VISIBLE
                    binding.signupEdtIcon3.visibility = View.GONE
                }
                else if(p0!!.length == 4){
                    binding.signupEdtIcon4.setImageResource(R.drawable.icon_check)
                    binding.signupEdtIcon3.visibility = View.VISIBLE
                    binding.signupNext.setTextColor(Color.parseColor("#FF000000"))
                }
                else{
                    binding.signupEdtIcon3.visibility = View.GONE
                    binding.signupEdtIcon4.visibility = View.GONE
                }
            }
        }))

        binding.signupBarBack.setOnClickListener(){
            onBackPressed()
        }

        binding.signupGetNumber.setOnClickListener {
            val phoneNum = binding.signupEdtTxt1.text.toString()
            val postPhoneSendRequest = PostPhoneSendRequest(phoneNum = phoneNum)
            progressON()
            SignupService(this).phonesend(postPhoneSendRequest)
            val preferencesEditor: SharedPreferences.Editor = sSharedPreferences.edit()
            preferencesEditor.putString("phoneNum", phoneNum)
            preferencesEditor.apply()
        }

        binding.signupTxt3.setOnClickListener{
            val phoneNum = binding.signupEdtTxt1.text.toString()
            val postPhoneSendRequest = PostPhoneSendRequest(phoneNum = phoneNum)
            progressON()
            SignupService(this).phonesend(postPhoneSendRequest)
        }
        binding.signupNext.setOnClickListener(){
            val certNum = binding.signupEdtTxt2.text.toString()

            if(certNum == sSharedPreferences.getString("certNum",null)){
                    startActivity(Intent(this, Signup2Activity::class.java))

            }
        }
    }

    override fun onPostPhoneSendSuccess(response: PhoneSendResponse) {
        progressOFF()
        if(response.isSuccess) {
            binding.signupTxt2.visibility = View.VISIBLE
            binding.signupTxt3.visibility = View.VISIBLE
            binding.signupEdtTxt2.visibility = View.VISIBLE
            binding.signupEdtIcon1.visibility = View.GONE
            val preferencesEditor: SharedPreferences.Editor = sSharedPreferences.edit()
            preferencesEditor.putString("certNum", response.result.certNum)
            preferencesEditor.apply()
        }
    }

    override fun onPostPhoneSendFailure(message: String) {

    }

    override fun finish(){
        super.finish()

        overridePendingTransition(R.anim.none, R.anim.slide_out_right)
    }
}