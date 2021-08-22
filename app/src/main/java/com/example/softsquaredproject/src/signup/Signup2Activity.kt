package com.example.softsquaredproject.src.signup

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.config.ApplicationClass.Companion.sSharedPreferences
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivitySignup2Binding
import com.example.softsquaredproject.databinding.ActivitySignupBinding
import com.example.softsquaredproject.src.home.HomeActivity
import com.example.softsquaredproject.src.login.LoginActivity
import com.example.softsquaredproject.src.signup.models.*

class Signup2Activity : BaseActivity<ActivitySignup2Binding>(ActivitySignup2Binding::inflate, TransitionMode.HORIZON), Signup2ActivityView {

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_in_right, R.anim.none)
        super.onCreate(savedInstanceState)

        binding.signup2Finish.setOnClickListener(){
            val finish : Boolean = sSharedPreferences.getBoolean("emailcheck",false)
            if(finish) {
                val phoneNum = sSharedPreferences.getString("phoneNum", null).toString()

                val email = binding.signup2EdtTxt1.text.toString()
                val nickNm = binding.signup2EdtTxt2.text.toString()
                val password = binding.signup2EdtTxt3.text.toString()
                val birthDay = binding.signup2EdtTxt4.text.toString()

                val preferencesEditor: SharedPreferences.Editor = sSharedPreferences.edit()
                preferencesEditor.putString("nickNm", nickNm)
                preferencesEditor.apply()

                val postSignUpRequest = PostSignUpRequest(
                    phoneNum = phoneNum,
                    email = email,
                    password = password,
                    nickNm = nickNm,
                    birthDay = birthDay
                )
                progressON()
                Signup2Service(this).signup(postSignUpRequest)
            }
        }
        binding.signup2BarBack.setOnClickListener(){
            onBackPressed()
        }

        binding.signup2EdtConstraint12.setOnClickListener(){
            val email = binding.signup2EdtTxt1.text.toString()
            val postEmailCheckRequest = PostEmailCheckRequest(email = email)
            progressON()
            Signup2Service(this).emailcheck(postEmailCheckRequest)
        }

        binding.signup2EdtTxt1.addTextChangedListener((object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if(p0!!.length > 0 && p0!!.length <20) {
                    binding.signup2EdtIcon2.setImageResource(R.drawable.icon_cancel)
                    binding.signup2EdtIcon2.visibility = View.VISIBLE
                }
                else if(p0!!.length == 20){
                    binding.signup2EdtIcon2.setImageResource(R.drawable.icon_check)
                }
                else{
                    binding.signup2EdtIcon2.visibility = View.GONE
                }
            }
        }))

        binding.signup2EdtTxt2.addTextChangedListener((object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if(p0!!.length > 0 && p0!!.length <10) {
                    binding.signup2EdtIcon3.setImageResource(R.drawable.icon_cancel)
                    binding.signup2EdtIcon3.visibility = View.VISIBLE
                }
                else if(p0!!.length == 10){
                    binding.signup2EdtIcon3.setImageResource(R.drawable.icon_check)
                }
                else{
                    binding.signup2EdtIcon3.visibility = View.GONE
                }
            }
        }))

        binding.signup2EdtTxt3.addTextChangedListener((object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if(p0!!.length > 0 && p0!!.length <25) {
                    binding.signup2EdtIcon4.setImageResource(R.drawable.icon_cancel)
                    binding.signup2EdtIcon4.visibility = View.VISIBLE
                }
                else if(p0!!.length == 25){
                    binding.signup2EdtIcon4.setImageResource(R.drawable.icon_check)
                }
                else{
                    binding.signup2EdtIcon4.visibility = View.GONE
                }
            }
        }))

        binding.signup2EdtTxt4.addTextChangedListener((object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if(p0!!.length > 0 && p0!!.length <10) {
                    binding.signup2EdtIcon5.setImageResource(R.drawable.icon_cancel)
                    binding.signup2EdtIcon5.visibility = View.VISIBLE
                }
                else if(p0!!.length == 10){
                    binding.signup2EdtIcon5.setImageResource(R.drawable.icon_check)
                }
                else{
                    binding.signup2EdtIcon5.visibility = View.GONE
                }
            }
        }))
    }

    override fun onPostEmailCheckSuccess(response: EmailCheckResponse) {
        progressOFF()
        if(response.isSuccess) {
            binding.signup2EdtIcon2.setImageResource(R.drawable.icon_check)
            binding.signup2Txt2.visibility = View.VISIBLE
            binding.signup2Txt3.visibility = View.VISIBLE
            binding.signup2Txt4.visibility = View.VISIBLE
            binding.signup2EdtConstraint2.visibility = View.VISIBLE
            binding.signup2EdtConstraint3.visibility = View.VISIBLE
            binding.signup2EdtConstraint4.visibility = View.VISIBLE
            binding.signup2EdtTxt1.isClickable = false
            val preferencesEditor: SharedPreferences.Editor = sSharedPreferences.edit()
            preferencesEditor.putBoolean("emailcheck", response.isSuccess)
            preferencesEditor.apply()
        }
    }

    override fun onPostEmailCheckFailure(message: String) {

    }

    override fun onPostSignUpSuccess(response: SignUpResponse) {
        progressOFF()
        if(response.isSuccess){
            startActivity(Intent(this, LoginActivity::class.java))
            showCustomToast("회원가입되었습니다.")
            finish()
        }
    }

    override fun onPostSignUpFailure(message: String) {
    }

    override fun finish(){
        super.finish()

        overridePendingTransition(R.anim.none, R.anim.slide_out_right)
    }
}