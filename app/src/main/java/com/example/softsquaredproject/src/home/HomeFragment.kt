package com.example.softsquaredproject.src.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.BaseFragment
import com.example.softsquaredproject.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home){

    private val title = arrayOf("배달", "포장", "쇼핑라이브","선물하기","전국별미")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewPager()
    }

    private fun setUpViewPager() {
        binding.homePager.apply {
            adapter = object : FragmentStateAdapter(requireActivity()) {
                override fun getItemCount(): Int {
                    return title.size
                }

                override fun createFragment(position: Int): Fragment {
                    return when (position) {
                        0 -> DeliveryFragment()
                        1 -> PackagingFragment()
                        2 -> GiftFragment()
                        3 -> ShoppingLiveFragment()
                        4 -> GiftFragment()
                        else -> DeliveryFragment()
                    }
                }
            }
        }
        TabLayoutMediator(binding.homeTabLayout, binding.homePager){tab, position ->
            tab.text = title[position]
        }.attach()
    }
    override fun onDestroyView() {
        super.onDestroyView()
    }
}