package com.example.softsquaredproject.src.detail_restaurant

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.config.ApplicationClass.Companion.sSharedPreferences
import com.example.softsquaredproject.config.BaseFragment
import com.example.softsquaredproject.databinding.FragmentReviewBinding
import com.example.softsquaredproject.src.detail_restaurant.models.*

data class reviewList(val nickNm: String, val img : String, val reviewCont : String, val commentCont : String, val menuNm : String)

class FragmentReview : BaseFragment<FragmentReviewBinding>(FragmentReviewBinding::bind, R.layout.fragment_review), DetailView{

    var reviewList = mutableListOf<reviewList>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val storeId = sSharedPreferences.getInt("storeId", 0)

        DetailService(this).get_review_info(storeId)
        DetailService(this).get_review_list(storeId,0,0)

        val index = sSharedPreferences.getInt("r2size",0)

        for(i in 0..index) {
            val nickNm = sSharedPreferences.getString("review_nickNm${i}",null)
            val img = sSharedPreferences.getString("reviewImgUrl${i}",null)
            val reviewCont = sSharedPreferences.getString("reviewCont${i}",null)
            val commentCont =sSharedPreferences.getString("commentCont${i}",null)
            val menuNm =sSharedPreferences.getString("menuNm${i}",null)

            reviewList.add(
                reviewList(
                    "${nickNm}",
                    "${img}",
                    "${reviewCont}",
                    "${commentCont}",
                    "${menuNm}"
                )
            )
        }
        val customAdapter = CustomAdapter4(activity as DetailActivity, reviewList)
        binding.reviewRecyclerview.adapter = customAdapter

        val layout2 = LinearLayoutManager(activity as DetailActivity)
        binding.reviewRecyclerview.layoutManager = layout2
        binding.reviewRecyclerview.setHasFixedSize(true)

        customAdapter.setItemClickListener(object : CustomAdapter4.ItemClickListener{
            override fun onClick(view: View, position: Int) {
                val item = reviewList[position]
            }
        })
    }

    override fun onGet_detail_info_Success(response: DetailResponse) {

    }

    override fun onGet_detail_info_Failure(message: String) {

    }

    override fun onGet_info_Success(response: InfoResponse) {

    }

    override fun onGet_info_Failure(message: String) {

    }

    override fun onGet_menu_Success(response: MenuResponse) {

    }

    override fun onGet_menu_Failure(message: String) {

    }

    override fun onGet_review_info_Success(response: ReviewInfoResponse) {
        if(response.isSuccess){
            if(response.result.reviewInfoImg.size != 0) {
                Glide.with(this).load(response.result.reviewInfoImg[0]).override(500, 500)
                    .into(binding.reviewImg1)
            }
            if(response.result.reviewInfoImg.size == 0) {
                binding.reviewImg1.visibility = View.GONE
            }
            binding.infoConstraint1Txt1.text = "${response.result.reviewInfo}"
            if("${response.result.ownerOneWord}" == "null") {
                binding.infoConstraint3.visibility = View.GONE
            }
            binding.infoConstraint3Txt3.text = "${response.result.ownerOneWord}"
            binding.reviewConstraint2Txt1.text = "${response.result.star}"
            binding.reviewLinear1Txt2.text = "${response.result.point5}"
            binding.reviewLinear2Txt2.text = "${response.result.point4}"
            binding.reviewLinear3Txt2.text = "${response.result.point3}"
            binding.reviewLinear4Txt2.text = "${response.result.point2}"
            binding.reviewLinear5Txt2.text = "${response.result.point1}"
        }
    }

    override fun onGet_review_info_Failure(message: String) {

    }

    override fun onGet_review_list_Success(response: ReviewListResponse) {
        if(response.isSuccess){
            val preferencesEditor: SharedPreferences.Editor = sSharedPreferences.edit()

            val index = response.result.reviews.size
            preferencesEditor.putInt("r2size",index-1)
            preferencesEditor.apply()

            for(i in 0 .. index -1){
                preferencesEditor.putString("review_nickNm${i}",response.result.reviews[i].nickNm)

                if("${response.result.reviews[i].reviewImgUrl}" != "null"){
                    preferencesEditor.putString("reviewImgUrl${i}",response.result.reviews[i].reviewImgUrl.toString())
                }
                if("${response.result.reviews[i].commentCont}" != "null"){
                    preferencesEditor.putString("commentCont${i}",response.result.reviews[i].commentCont.toString())
                }
                preferencesEditor.putString("reviewCont${i}",response.result.reviews[i].reviewCont)
                if(response.result.reviews[i].orderMenuInfo.size != 0)
                {
                    preferencesEditor.putString("menuNm${i}",response.result.reviews[i].orderMenuInfo[0].menuNm)
                }
                else if(response.result.reviews[i].orderMenuInfo.size == 0){
                    preferencesEditor.putString("menuNm${i}","no")
                }
                preferencesEditor.apply()
            }
            binding.infoTxt5.text = "최근 리뷰 ${response.result.reviewCnt}개"
            binding.infoTxt6.text = "사장님 댓글 ${response.result.commentCnt}개"
        }
    }

    override fun onGet_review_list_Failure(message: String) {

    }
}