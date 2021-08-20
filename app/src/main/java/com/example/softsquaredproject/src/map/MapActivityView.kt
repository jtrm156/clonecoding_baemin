package com.example.softsquaredproject.src.map

import com.example.softsquaredproject.src.map.models.MapResponse

interface MapActivityView {

    fun onGettrans_xySuccess(response : MapResponse)

    fun onGettrans_xyFailure(message: String)
}