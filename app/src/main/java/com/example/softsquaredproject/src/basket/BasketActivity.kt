package com.example.softsquaredproject.src.basket

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivityShoppingBasketBinding
import com.example.softsquaredproject.src.home.Foodcategory
import com.example.softsquaredproject.src.order.CustomAdapter2
import com.example.softsquaredproject.src.order.RestaurantListActivity

data class basketlist(val menu : String, val price : String)

class BasketActivity : BaseActivity<ActivityShoppingBasketBinding>(ActivityShoppingBasketBinding::inflate,TransitionMode.HORIZON) {

    var basketList = mutableListOf<basketlist>()
    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_in_right, R.anim.none)
        super.onCreate(savedInstanceState)

        binding.basketBarBack.setOnClickListener(){
            onBackPressed()
        }

        basketList.add(basketlist("유린기[새콤달콤]","가격 : 17000원"))
        basketList.add(basketlist("유린기[새콤달콤]","가격 : 17000원"))
        val customAdapter = CustomAdapter3(this, basketList)
        binding.basketRecyclerview.adapter = customAdapter

        val layout2 = LinearLayoutManager(this)
        binding.basketRecyclerview.layoutManager = layout2
        binding.basketRecyclerview.setHasFixedSize(true)
    }

    override fun finish(){
        super.finish()

        overridePendingTransition(R.anim.none, R.anim.slide_out_right)
    }
}