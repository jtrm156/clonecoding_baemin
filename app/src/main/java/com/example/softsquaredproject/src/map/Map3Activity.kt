package com.example.softsquaredproject.src.map

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.config.ApplicationClass.Companion.sSharedPreferences
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivityMap2Binding
import com.example.softsquaredproject.databinding.ActivityMap3Binding
import com.example.softsquaredproject.src.start.StartActivity
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.OverlayImage

class Map3Activity : BaseActivity<ActivityMap3Binding>(ActivityMap3Binding::inflate),
    OnMapReadyCallback {

    private lateinit var naverMap: NaverMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val x = sSharedPreferences.getString("cLatitude",null)!!.toDouble()
        val y = sSharedPreferences.getString("cLongitude",null)!!.toDouble()

        val index = sSharedPreferences.getInt("address_posi",0)

        val road_ad = sSharedPreferences.getString("rAddr${index}",null)!!.toString()
        val jibun_ad = sSharedPreferences.getString("jAddr${index}",null)!!.toString()

        binding.map2Txt1.text = jibun_ad
        binding.map2Txt3.text = road_ad

        val cameraPosition = CameraPosition(
            LatLng(x, y), // 대상 지점
            17.0, // 줌 레벨
        )

        val options = NaverMapOptions()
            .camera(cameraPosition)

        val fm = supportFragmentManager
        val mapFragment = fm.findFragmentById(R.id.map) as MapFragment?
            ?: MapFragment.newInstance(options).also {
                fm.beginTransaction().add(R.id.map, it).commit()
            }

        mapFragment.getMapAsync(this)

        binding.map2Constraint2.setOnClickListener(){
            startActivity(Intent(this, MapActivity::class.java))
            finish()
        }

        binding.map2Constraint4.setOnClickListener(){
            val final_address = binding.map2Edt.text.toString()
            val preferencesEditor: SharedPreferences.Editor = sSharedPreferences.edit()
            preferencesEditor.putString("final_address2", final_address)
            preferencesEditor.apply()
            startActivity(Intent(this, StartActivity::class.java))
            finish()
        }
    }

    override fun onMapReady(naverMap: NaverMap) {
        this.naverMap = naverMap
        naverMap.uiSettings.isLocationButtonEnabled = false
        naverMap.uiSettings.isZoomControlEnabled = false

        val x = sSharedPreferences.getString("cLatitude",null)!!.toDouble()
        val y = sSharedPreferences.getString("cLongitude",null)!!.toDouble()

        val marker = Marker()
        marker.icon = OverlayImage.fromResource(R.drawable.icon_marker4)
        marker.position = LatLng(x, y)
        marker.map = naverMap
    }
}