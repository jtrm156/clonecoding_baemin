package com.example.softsquaredproject.src.basket

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.ApplicationClass.Companion.sSharedPreferences
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivityShoppingBasketBinding
import com.example.softsquaredproject.src.detail_restaurant.DetailActivity
import com.example.softsquaredproject.src.home.Foodcategory
import com.example.softsquaredproject.src.home.HomeFragment
import com.example.softsquaredproject.src.order.CustomAdapter2
import com.example.softsquaredproject.src.order.RestaurantListActivity
import com.example.softsquaredproject.src.orderlist.OrderListFragment
import com.example.softsquaredproject.src.payment.PaymentActivity

data class basketlist(val menu : String, val price : String)

class BasketActivity : BaseActivity<ActivityShoppingBasketBinding>(ActivityShoppingBasketBinding::inflate,TransitionMode.HORIZON) {

    var basketList = mutableListOf<basketlist>()
    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_in_right, R.anim.none)
        super.onCreate(savedInstanceState)

        binding.basketCheck1.isChecked = true

        binding.basketBarBack.setOnClickListener(){
            onBackPressed()
        }

        //basketList.add(basketlist("${sSharedPreferences.getString("item_menuNm",null)}","${sSharedPreferences.getString("item_price",null)}"))

        val customAdapter = CustomAdapter3(this, basketList)
        binding.basketRecyclerview.adapter = customAdapter

        val layout2 = LinearLayoutManager(this)
        binding.basketRecyclerview.layoutManager = layout2
        binding.basketRecyclerview.setHasFixedSize(true)

        customAdapter.setItemClickListener(object : CustomAdapter3.ItemClickListener{
            override fun onClick(view: View, position: Int) {
                val item = basketList[position]
            }
        })

        customAdapter.addItem(basketlist("${sSharedPreferences.getString("item_menuNm",null)}","${sSharedPreferences.getInt("item_price", 0)}"))
        customAdapter.notifyDataSetChanged()

        binding.basketTxt6.text = "${sSharedPreferences.getInt("item_price", 0)}원 주문하기"

        binding.basketConstraint4.setOnClickListener(){
            startActivity(Intent(this, PaymentActivity::class.java))
        }

        binding.basketConstraint3.setOnClickListener(){
            startActivity(Intent(this, DetailActivity::class.java))
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.order_list_fragment, OrderListFragment())
            .commitAllowingStateLoss()
    }

    override fun finish(){
        super.finish()

        overridePendingTransition(R.anim.none, R.anim.slide_out_right)
    }
}