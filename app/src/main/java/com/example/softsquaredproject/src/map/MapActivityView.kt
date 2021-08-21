package com.example.softsquaredproject.src.map

import com.example.softsquaredproject.src.map.models.MapResponse
import com.example.softsquaredproject.src.map.models2.MapResponse2

interface MapActivityView {

    fun onGettrans_xySuccess(response : MapResponse)

    fun onGettrans_xyFailure(message: String)

    fun onGettrans_adSuccess(response : MapResponse2)

    fun onGettrans_adFailure(message: String)
}