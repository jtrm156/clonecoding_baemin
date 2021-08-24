package com.example.softsquaredproject.src.detail_restaurant

import android.os.Bundle
import android.view.View
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.ApplicationClass.Companion.sSharedPreferences
import com.example.softsquaredproject.config.BaseFragment
import com.example.softsquaredproject.databinding.FragmentDetailDeliveryBinding

class FragmentDeliveryOrder : BaseFragment<FragmentDetailDeliveryBinding>(FragmentDetailDeliveryBinding::bind, R.layout.fragment_detail_delivery) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.deliveryTxt1.text = "${sSharedPreferences.getInt("minPrice",0)}"+"원"
        binding.deliveryTxt2.text = "${sSharedPreferences.getString("paymentWay",null)}"
        binding.deliveryTxt3.text = "${sSharedPreferences.getString("deliverTime",null)}"+"분 소요 예상"
        binding.deliveryTxt4.text = "${sSharedPreferences.getInt("minDeliverTip",0)}"+"원 ~ "
        binding.deliveryTxt5.text = "${sSharedPreferences.getInt("maxDeliverTip",0)}"+"원"
    }
}