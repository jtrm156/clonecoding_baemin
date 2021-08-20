package com.example.softsquaredproject.src.map

import android.content.SharedPreferences
import android.graphics.PointF
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivityMapBinding
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.util.FusedLocationSource
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.ApplicationClass.Companion.sSharedPreferences
import com.example.softsquaredproject.src.login.LoginService
import com.example.softsquaredproject.src.login.models.PostLoginRequest
import com.example.softsquaredproject.src.map.models.MapResponse
import java.net.URLDecoder

class MapActivity : BaseActivity<ActivityMapBinding>(ActivityMapBinding::inflate, TransitionMode.HORIZON),
    OnMapReadyCallback, MapActivityView {

    private lateinit var naverMap: NaverMap
    private lateinit var locationSource : FusedLocationSource
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val x =sSharedPreferences.getString("uLatitude", null)!!.toDouble()
        val y =sSharedPreferences.getString("uLongitude", null)!!.toDouble()
        locationSource = FusedLocationSource(this,LOCATION_PERMISSION_REQUEST_CODE)
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
        /*
        mapView = binding.mapNaver
        mapView.onCreate(savedInstanceState)
        */
        mapFragment.getMapAsync(this)
        //mapView.getMapAsync(this)


        binding.mapConstraint2.setOnClickListener(){
            val cameraUpdate = CameraUpdate.scrollTo(LatLng(x, y))
                .animate(CameraAnimation.Easing)
            naverMap.moveCamera(cameraUpdate)
        }
        binding.mapBarBack.setOnClickListener(){
            onBackPressed()
        }
    }

    override fun onMapReady(naverMap: NaverMap) {
        this.naverMap = naverMap
        naverMap.locationSource = locationSource
        naverMap.uiSettings.isLocationButtonEnabled = false
        naverMap.uiSettings.isZoomControlEnabled = false

        naverMap.addOnCameraChangeListener { reason, animated ->
            Log.i("NaverMap", "카메라 변경 - reason: $reason, animated: $animated")
            if(reason == -1){
                //binding.mapTxt2.visibility = View.GONE
                //binding.mapTxt3.visibility = View.GONE
                //binding.mapTxt5.visibility = View.VISIBLE
                //binding.mapConstraint4.setBackgroundColor(R.drawable.background_map3)
                val projection = naverMap.projection
                val coord = projection.fromScreenLocation(PointF(50f, 50f))
                showCustomToast("${coord.latitude}, ${coord.longitude}")
                val preferencesEditor: SharedPreferences.Editor = sSharedPreferences.edit()
                preferencesEditor.putString("cLatitude", coord.latitude.toString())
                preferencesEditor.putString("cLongitude", coord.longitude.toString())
                preferencesEditor.apply()

                var xy = URLDecoder.decode("${coord.longitude},${coord.latitude}", "UTF-8")
                var orders = URLDecoder.decode("legalcode,addr,admcode,roadaddr", "UTF-8")

                MapService(this).gettrans_xy(xy,"json",orders)
            }
            else{
                val animation = AnimationUtils.loadAnimation(this, R.anim.alpha_map)

                binding.mapConstraint1.startAnimation(animation)
                //binding.mapTxt2.visibility = View.VISIBLE
                //binding.mapTxt3.visibility = View.VISIBLE
                //binding.mapTxt5.visibility = View.GONE
            }
        }

        /*안됨... ㅠㅠ
        naverMap.addOnCameraIdleListener { reason, animated ->
            Log.i("NaverMap", "카메라 변경 - reson: $reason, animated: $animated")
        }
        */
        /*
        naverMap.setOnMapClickListener { point, coord ->
            Toast.makeText(this, "${coord.latitude}, ${coord.longitude}",
                Toast.LENGTH_SHORT).show()
        }
        */
        /*
        naverMap.setOnMapLongClickListener { point, coord ->
            Toast.makeText(this, "${coord.latitude}, ${coord.longitude}",
                Toast.LENGTH_SHORT).show()
        }
        naverMap.setOnMapDoubleTapListener { point, coord ->
            Toast.makeText(this, "${coord.latitude}, ${coord.longitude}",
                Toast.LENGTH_SHORT).show()
            true
        }
        naverMap.setOnMapTwoFingerTapListener { point, coord ->
            Toast.makeText(this, "${coord.latitude}, ${coord.longitude}",
                Toast.LENGTH_SHORT).show()
            true
        }
        */
    }

    /*
    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>,
                                            grantResults: IntArray) {

        if (locationSource.onRequestPermissionsResult(requestCode, permissions,
                grantResults)) {
            if (!locationSource.isActivated) { // 권한 거부됨
                naverMap.locationTrackingMode = LocationTrackingMode.None
            } else {
                naverMap.locationTrackingMode = LocationTrackingMode.Follow// 현위치 버튼 컨트롤 활성
            }
            return
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
    */
    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1000
    }

    override fun onGettrans_xySuccess(response: MapResponse) {
        if(response.status.code == 0){
            val index = response.results.size - 1

            for(i in 0 .. index){

                if(response.results[i].name == "addr"){
                    var code = response.results[i].code.id
                    val a2 = response.results[i].region.area2.name
                    val a3 = response.results[i].region.area3.name
                    val n1 = response.results[i].land.number1

                    binding.mapTxt2.text = "${a2} ${a3} ${n1}"

                    val preferencesEditor: SharedPreferences.Editor = sSharedPreferences.edit()
                    preferencesEditor.putString("code", code)
                    preferencesEditor.apply()
                }
            }
        }
    }

    override fun onGettrans_xyFailure(message: String) {

    }
}