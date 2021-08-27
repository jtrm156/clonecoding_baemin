package com.example.softsquaredproject.src.orderlist

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.config.ApplicationClass.Companion.sSharedPreferences
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivityOrderListBinding
import com.example.softsquaredproject.src.order.CustomAdapter2
import com.example.softsquaredproject.src.order.OrderFragment
import com.example.softsquaredproject.src.order.RestaurantListActivity
import com.example.softsquaredproject.src.order.restaurantList
import com.example.softsquaredproject.src.orderlist.model.OrderListResponse


class OrderList : BaseActivity<ActivityOrderListBinding>(ActivityOrderListBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_in_right, R.anim.none)
        super.onCreate(savedInstanceState)

        binding.basketBarBack.setOnClickListener(){
            finish()
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