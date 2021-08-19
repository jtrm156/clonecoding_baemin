package com.example.softsquaredproject.src.search_address

import android.content.Intent
import android.os.Bundle
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivitySearchAddressBinding
import com.example.softsquaredproject.src.map.MapActivity
import com.example.softsquaredproject.src.signup.Signup2Activity

class SearchadActivity : BaseActivity<ActivitySearchAddressBinding>(ActivitySearchAddressBinding::inflate, TransitionMode.HORIZON) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.searchCurrentLocation.setOnClickListener(){
            startActivity(Intent(this, MapActivity::class.java))
        }
    }
}