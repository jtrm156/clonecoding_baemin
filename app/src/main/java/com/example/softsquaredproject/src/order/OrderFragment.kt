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

    private val title = arrayOf("한식", "분식", "돈까스·회·일식","치킨","피자","아시안·양식","중식","족발·보쌈","야식","찜·탕","도시락","카페·디저트","패스트푸드")

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
                        1 -> KoreanFragment()
                        2 -> KoreanFragment()
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