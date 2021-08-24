package com.example.softsquaredproject.src.detail_restaurant

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.config.BaseFragment
import com.example.softsquaredproject.databinding.FragmentInformationBinding
import com.example.softsquaredproject.src.detail_restaurant.models.DetailResponse
import com.example.softsquaredproject.src.detail_restaurant.models.InfoResponse
import com.example.softsquaredproject.src.detail_restaurant.models.MenuResponse

class FragmentInformation : BaseFragment<FragmentInformationBinding>(FragmentInformationBinding::bind, R.layout.fragment_information), DetailView {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val storeId = ApplicationClass.sSharedPreferences.getInt("storeId", 0)

        DetailService(this).get_info_list(storeId)
    }

    override fun onGet_detail_info_Success(response: DetailResponse) {

    }

    override fun onGet_detail_info_Failure(message: String) {

    }

    override fun onGet_info_Success(response: InfoResponse) {
        if(response.isSuccess){
            Glide.with(this).load( response.result.storeIntroImg[0].storeImgUrl).into(binding.infoImg1)

            if(response.result.storeInfo == null){
                binding.infoTxt2.text = " "
            }
            else{
                val storeIntro = response.result.storeIntro
                binding.infoTxt2.text = "${storeIntro}"
            }
        }
    }

    override fun onGet_info_Failure(message: String) {

    }

    override fun onGet_menu_Success(response: MenuResponse) {

    }

    override fun onGet_menu_Failure(message: String) {

    }
}