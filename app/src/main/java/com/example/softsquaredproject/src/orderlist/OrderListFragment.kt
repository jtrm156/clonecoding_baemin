package com.example.softsquaredproject.src.orderlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.BaseFragment
import com.example.softsquaredproject.databinding.FragmentOrderListBinding
import com.example.softsquaredproject.src.home.DeliveryFragment
import com.example.softsquaredproject.src.home.GiftFragment
import com.example.softsquaredproject.src.home.PackagingFragment
import com.example.softsquaredproject.src.home.ShoppingLiveFragment
import com.google.android.material.tabs.TabLayoutMediator

class OrderListFragment : BaseFragment<FragmentOrderListBinding>(FragmentOrderListBinding::bind, R.layout.fragment_order_list) {
    private val title = arrayOf("배달/포장", "B마트", "쇼핑라이브","전국별미")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewPager()
    }

    private fun setUpViewPager() {
        binding.orderPager.apply {
            adapter = object : FragmentStateAdapter(requireActivity()) {
                override fun getItemCount(): Int {
                    return title.size
                }

                override fun createFragment(position: Int): Fragment {
                    return when (position) {
                        0 -> Order_packing_fragment()
                        1 -> Order_packing_fragment()
                        2 -> Order_packing_fragment()
                        3 -> Order_packing_fragment()
                        else -> Order_packing_fragment()
                    }
                }
            }
        }
        TabLayoutMediator(binding.orderTabLayout, binding.orderPager){tab, position ->
            tab.text = title[position]
        }.attach()
    }
    override fun onDestroyView() {
        super.onDestroyView()
    }
}