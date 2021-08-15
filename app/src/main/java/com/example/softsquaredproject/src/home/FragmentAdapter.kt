/*
package com.example.softsquaredproject.src.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FragmentAdapter(fm : FragmentManager): FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        val fragment =  when(position)
        {
            0-> tab1Fragment().newInstant()
            1-> tab2Fragment().newInstant()
            2-> tab3Fragment().newInstant()
            else -> tab1Fragment().newInstant()
        }
        return fragment
    }

    //tab의 개수만큼 return
    override fun getCount(): Int = 5

    //tab의 이름 fragment마다 바꾸게 하기
    override fun getPageTitle(position: Int): CharSequence? {
        val title = when(position)
        {
            0->"0ne"
            1->"Two"
            2->"Three"
            else -> "main"
        }
        return title     }
}
*/