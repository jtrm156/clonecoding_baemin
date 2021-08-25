package com.example.softsquaredproject.src.detail_restaurant

import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.View
import com.bumptech.glide.Glide
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.config.BaseFragment
import com.example.softsquaredproject.databinding.FragmentInformationBinding
import com.example.softsquaredproject.src.detail_restaurant.models.*


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

            val content = SpannableString(response.result.storePhoneNum)
            content.setSpan(UnderlineSpan(), 0, response.result.storePhoneNum.length, 0)
            binding.infoConstraint2Txt4.setText(content)

            if(response.result.storeIntroImg.size == 0) {
                binding.infoConstraint1.visibility = View.GONE
            }
            else if(response.result.storeIntroImg.size > 0){
                Glide.with(this).load( response.result.storeIntroImg[0].storeImgUrl).into(binding.infoImg1)
            }

            if("${response.result.storeIntro}" == "null"){
                binding.infoTxt2.visibility = View.GONE
            }
            binding.infoTxt2.text = "${response.result.storeIntro}"
        }
    }

    override fun onGet_info_Failure(message: String) {

    }

    override fun onGet_menu_Success(response: MenuResponse) {

    }

    override fun onGet_menu_Failure(message: String) {

    }

    override fun onGet_review_info_Success(response: ReviewInfoResponse) {

    }

    override fun onGet_review_info_Failure(message: String) {

    }

    override fun onGet_review_list_Success(response: ReviewListResponse) {

    }

    override fun onGet_review_list_Failure(message: String) {

    }
}