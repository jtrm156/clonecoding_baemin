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
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.config.ApplicationClass.Companion.sSharedPreferences
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivitySearchAddressBinding
import com.example.softsquaredproject.src.map.MapActivity
import com.example.softsquaredproject.src.signup.Signup2Activity
import net.daum.mf.map.api.MapPoint

class SearchadActivity : BaseActivity<ActivitySearchAddressBinding>(ActivitySearchAddressBinding::inflate, TransitionMode.HORIZON) {
    val PERMISSIONS_REQUEST_CODE = 100
    var REQUIRED_PERMISSIONS = arrayOf<String>( Manifest.permission.ACCESS_FINE_LOCATION)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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