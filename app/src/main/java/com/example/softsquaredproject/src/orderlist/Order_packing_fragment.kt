package com.example.softsquaredproject.src.orderlist

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.ApplicationClass
import com.example.softsquaredproject.config.BaseFragment
import com.example.softsquaredproject.databinding.FragmentOrderPackingBinding
import com.example.softsquaredproject.src.orderlist.model.OrderListResponse

data class order_List(val storeNm : String, val storeLogoURL : String, val orderMenu : String, val totalPrice : Int,
                      val isPossibleReview : String, val orderedAt : String, val isDelivered : String)

class Order_packing_fragment : BaseFragment<FragmentOrderPackingBinding>(FragmentOrderPackingBinding::bind, R.layout.fragment_order_packing), OrderListView {

    var order_list = mutableListOf<order_List>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        OrderListService(this).get_order_list()


        val index = ApplicationClass.sSharedPreferences.getInt("Osize",0)

        for(i in 0 .. index){
            order_list.add(order_List("${ApplicationClass.sSharedPreferences.getString("O_storeNm${i}",null)}",
                "${ApplicationClass.sSharedPreferences.getString("O-storeLogoUrl${i}",null)}",
                "${ApplicationClass.sSharedPreferences.getString("orderMenu${i}",null)}",
                ApplicationClass.sSharedPreferences.getInt("totalPrice${i}", 0),
                "${ApplicationClass.sSharedPreferences.getString("isPossibleReview${i}",null)}",
                "${ApplicationClass.sSharedPreferences.getString("orderAt${i}",null)}",
                "${ApplicationClass.sSharedPreferences.getString("isdelivered${i}",null)}"))
        }

        val OrderAdapter = OrderListAdapter(activity as OrderList, order_list)
        binding.orderListRecyclerView.adapter = OrderAdapter

        val layout2 = LinearLayoutManager(activity as OrderList)
        binding.orderListRecyclerView.layoutManager = layout2
        binding.orderListRecyclerView.setHasFixedSize(true)

        OrderAdapter.setItemClickListener(object : OrderListAdapter.ItemClickListener{
            override fun onClick(view: View, position: Int) {
                val item = order_list[position]
            }
        })
    }

    override fun onGet_Order_List_Success(response: OrderListResponse) {
        if(response.isSuccess){
            val preferencesEditor: SharedPreferences.Editor = ApplicationClass.sSharedPreferences.edit()

            val index = response.result.size - 1

            preferencesEditor.putInt("Osize", index)
            preferencesEditor.apply()
            for(i in 0 .. index){
                preferencesEditor.putString("O_storeNm${i}",response.result[i].storeNm)
                preferencesEditor.putString("O-storeLogoUrl${i}", "https://prod.wooa-bm.shop" + response.result[i].storeLogoUrl)
                preferencesEditor.putString("orderMenu${i}",response.result[i].orderMenu)
                preferencesEditor.putInt("totalPrice${i}",response.result[i].totalPrice)
                preferencesEditor.putString("isPossibleReview${i}", response.result[i].isPossibleReview)
                preferencesEditor.putString("orderAt${i}",response.result[i].orderedAt)
                preferencesEditor.putString("isdelivered${i}",response.result[i].isDelivered)
                preferencesEditor.apply()
            }
        }
    }

    override fun onGet_Order_List_Failure(message: String) {

    }
}