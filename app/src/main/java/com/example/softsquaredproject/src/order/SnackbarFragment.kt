package com.example.softsquaredproject.src.order

import android.os.Bundle
import android.view.View
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.BaseFragment
import com.example.softsquaredproject.databinding.ActivityCutletBinding
import com.example.softsquaredproject.databinding.ActivitySnackbarBinding

class SnackbarFragment : BaseFragment<ActivitySnackbarBinding>(ActivitySnackbarBinding::bind, R.layout.activity_cutlet) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}