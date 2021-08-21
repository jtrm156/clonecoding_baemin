package com.example.softsquaredproject.src.order

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.BaseFragment
import com.example.softsquaredproject.databinding.FragmentOrderBinding
import com.google.android.material.tabs.TabLayoutMediator

class OrderFragment : BaseFragment<FragmentOrderBinding>(FragmentOrderBinding::bind, R.layout.fragment_order) {

    private val title = arrayOf("배달﹒포장", "B마트", "쇼핑라이브")

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
                        0 -> KoreanFragment()
                        1 -> SnackbarFragment()
                        2 -> cutletFragment()
                        else -> KoreanFragment()
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