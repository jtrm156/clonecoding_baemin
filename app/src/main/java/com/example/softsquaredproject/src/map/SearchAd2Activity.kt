package com.example.softsquaredproject.src.map

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.config.ApplicationClass.Companion.sSharedPreferences
import com.example.softsquaredproject.config.BaseActivity
import com.example.softsquaredproject.databinding.ActivitySearchAddress2Binding
import com.example.softsquaredproject.databinding.ActivitySearchAddressBinding
import com.example.softsquaredproject.src.map.models.MapResponse
import com.example.softsquaredproject.src.map.models2.MapResponse2
import com.example.softsquaredproject.src.map.models3.SearchAddressResponse
import com.example.softsquaredproject.src.order.CustomAdapter2
import com.example.softsquaredproject.src.order.RestaurantListActivity
import com.example.softsquaredproject.src.start.StartActivity

data class addrlist(val rAddr : String, val jAddr : String)

class SearchAd2Activity: BaseActivity<ActivitySearchAddress2Binding>(ActivitySearchAddress2Binding::inflate, TransitionMode.HORIZON), MapActivityView{

    val addrList = mutableListOf<addrlist>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val search_address = sSharedPreferences.getString("search_address",null).toString()
        val index = sSharedPreferences.getInt("asize",0)

        binding.searchEdt1.setText("${search_address}")

        binding.searchadBarBack.setOnClickListener(){
            onBackPressed()
        }

        binding.searchEdt1Img1.setOnClickListener(){
            MapService(this).get_search_address_ad(3, binding.searchEdt1.text.toString())
            startActivity(Intent(this, SearchAd2Activity::class.java))
            binding.searchEdt1.setText("${binding.searchEdt1.text}")
            finish()
        }

        MapService(this).get_search_address_ad(3, search_address)

        for(i in 0 .. index-1){
            addrList.add(addrlist(sSharedPreferences.getString("rAddr${i}", null).toString(), sSharedPreferences.getString("jAddr${i}", null).toString()))
        }

        val searchAdapter = SearchAdapter(this, addrList)
        binding.searchAd2Recycler.adapter = searchAdapter

        val layout2 = LinearLayoutManager(this)
        binding.searchAd2Recycler.layoutManager = layout2
        binding.searchAd2Recycler.setHasFixedSize(true)

        searchAdapter.setItemClickListener(object : SearchAdapter.ItemClickListener{
            override fun onClick(view: View, position: Int) {
                val item = addrList[position]
                val preferencesEditor: SharedPreferences.Editor = sSharedPreferences.edit()
                preferencesEditor.putInt("address_posi", position)
                preferencesEditor.apply()
            }
        })
    }

    override fun onGettrans_xySuccess(response: MapResponse) {

    }

    override fun onGettrans_xyFailure(message: String) {

    }

    override fun onGettrans_adSuccess(response: MapResponse2) {

    }

    override fun onGettrans_adFailure(message: String) {

    }

    override fun onGet_search_ad_Success(response: SearchAddressResponse) {
        if(response.isSuccess){
            val index = response.result.addressInfo.size

            for(i in 0..index-1){
                val preferencesEditor: SharedPreferences.Editor = sSharedPreferences.edit()

                preferencesEditor.putInt("asize", response.result.addressInfo.size)
                preferencesEditor.putString("rAddr${i}", response.result.addressInfo[i].roadAddr)
                preferencesEditor.putString("jAddr${i}", response.result.addressInfo[i].jibunAddr)
                preferencesEditor.apply()
            }
        }
    }

    override fun onGet_search_ad_Failure(message: String) {

    }
}