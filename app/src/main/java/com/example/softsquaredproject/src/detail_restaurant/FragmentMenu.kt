package com.example.softsquaredproject.src.detail_restaurant

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.BaseFragment
import com.example.softsquaredproject.databinding.FragmentMenuBinding
import com.example.softsquaredproject.src.detail_restaurant.FragmentDeliveryOrder
import com.example.softsquaredproject.src.order.KoreanFragment
import com.example.softsquaredproject.src.order.OrderFragment
import com.google.android.material.tabs.TabLayoutMediator

class FragmentMenu : BaseFragment<FragmentMenuBinding>(FragmentMenuBinding::bind, R.layout.fragment_menu) {
    private val title = arrayOf("메뉴","정보", "리뷰")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewPager()
    }

    private fun setUpViewPager() {
        binding.menuPager.apply {
            adapter = object : FragmentStateAdapter(requireActivity()) {
                override fun getItemCount(): Int {
                    return title.size
                }

                override fun createFragment(position: Int): Fragment {
                    return when (position) {
                        0 -> FragmentMenu2()
                        1 -> FragmentInformation()
                        2 -> FragmentReview()
                        else -> FragmentReview()
                    }
                }
            }
        }
        TabLayoutMediator(binding.menuTabLayout, binding.menuPager){tab, position ->
            tab.text = title[position]
        }.attach()
    }
    override fun onDestroyView() {
        super.onDestroyView()
    }
}