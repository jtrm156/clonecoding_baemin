package com.example.softsquaredproject.src.search_address

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.config.ApplicationClass.Companion.sSharedPreferences
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivitySearchAddressBinding
import com.example.softsquaredproject.src.map.MapActivity
import com.example.softsquaredproject.src.map.SearchAd2Activity
import com.example.softsquaredproject.src.map.SearchAdapter
import com.example.softsquaredproject.src.map.addrlist
import com.example.softsquaredproject.src.signup.Signup2Activity
import net.daum.mf.map.api.MapPoint

data class addrlist2(val rAddr2 : String, val jAddr2 : String, val fAddr2 : String)

class SearchadActivity : BaseActivity<ActivitySearchAddressBinding>(ActivitySearchAddressBinding::inflate, TransitionMode.HORIZON) {
    val addrList2 = mutableListOf<addrlist2>()
    val PERMISSIONS_REQUEST_CODE = 100
    var REQUIRED_PERMISSIONS = arrayOf<String>( Manifest.permission.ACCESS_FINE_LOCATION)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val road_ad = sSharedPreferences.getString("road_address",null)!!.toString()
        val jibun_ad = sSharedPreferences.getString("address",null)!!.toString()
        val final_ad = sSharedPreferences.getString("final_address",null)!!.toString()

        addrList2.add(addrlist2("${road_ad}","${jibun_ad}", "${final_ad}"))

        val searchAdapter = RecentadAdapter(this, addrList2)
        binding.searchadRecycler.adapter = searchAdapter

        val layout2 = LinearLayoutManager(this)
        binding.searchadRecycler.layoutManager = layout2
        binding.searchadRecycler.setHasFixedSize(true)

        searchAdapter.setItemClickListener(object : RecentadAdapter.ItemClickListener{
            override fun onClick(view: View, position: Int) {
                val item = addrList2[position]
            }
        })

        binding.searchSearchBtn1.setOnClickListener{
            val preferencesEditor: SharedPreferences.Editor = sSharedPreferences.edit()


            val address = binding.searchEdt1.text.toString()

            preferencesEditor.putString("search_address", address)
            preferencesEditor.apply()
            startActivity(Intent(this, SearchAd2Activity::class.java))
        }

        binding.searchBarBack.setOnClickListener(){
            finish()
        }

        binding.searchCurrentLocation.setOnClickListener(){
            val permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            if(permissionCheck == PackageManager.PERMISSION_GRANTED) {
                val lm: LocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
                try {
                    val userNowLocation: Location? =
                        lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                    val uLatitude = userNowLocation?.latitude
                    val uLongitude = userNowLocation?.longitude
                    val preferencesEditor: SharedPreferences.Editor = sSharedPreferences.edit()
                    preferencesEditor.putString("uLatitude", uLatitude.toString())
                    preferencesEditor.putString("uLongitude", uLongitude.toString())
                    preferencesEditor.apply()
                }catch(e: NullPointerException){
                    Log.e("LOCATION_ERROR", e.toString())
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        ActivityCompat.finishAffinity(this)
                    }else{
                        ActivityCompat.finishAffinity(this)
                    }
                    System.exit(0)
                }
                startActivity(Intent(this, MapActivity::class.java))
            }else{
                Toast.makeText(this, "위치 권한이 없습니다.", Toast.LENGTH_SHORT).show()
                ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, PERMISSIONS_REQUEST_CODE )
            }
        }
    }
}