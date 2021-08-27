package com.example.softsquaredproject.src.orderlist

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.softsquaredproject.R
import com.example.softsquaredproject.databinding.ItemListOrderBinding
import com.example.softsquaredproject.databinding.RestaurantListItemBinding
import com.example.softsquaredproject.src.detail_restaurant.DetailActivity
import com.example.softsquaredproject.src.order.restaurantList

class OrderListAdapter(private val context: Context, var OrderListArrayList: MutableList<order_List>) :
    RecyclerView.Adapter<OrderListAdapter.ItemViewHolder>() {
    //Layout들과 RecyclerView를 연결시킬 Adapter(데이터를 받아오고 이를 레이아웃에 직접 연결하는 함수를 실행시키는 클래스)

    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }
    private lateinit var itemClickListener: ItemClickListener

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    inner class ItemViewHolder(private val binding: ItemListOrderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(order_list: order_List, num: Int, context: Context) {

            /*
            val resourceId = context.resources.getIdentifier(
                restaurantlist.img.toString(),
                "drawable",
                context.packageName
            )
            */


            //binding.restaurantImage.setImageResource(resourceId)

            Glide.with(itemView).load(order_list.storeLogoURL).error(R.drawable.baemin_category_icon6).diskCacheStrategy(
                DiskCacheStrategy.RESOURCE).fitCenter().into(binding.itemImg2)
            binding.itemTxt1.text = order_list.orderedAt
            binding.itemTxt2.text = order_list.isDelivered
            binding.itemTxt3.text = order_list.storeNm
            binding.itemTxt5.text = "${order_list.orderMenu} ${order_list.totalPrice}"

        }
    } //ViewHolder는 클래스 내에 View를 저장하는 변수를 만들어 그 안에 데이터를 직접 연결시킬 수 있는 클래스, 디자인 패턴

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemListOrderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    } //화면을 최초 로딩하여 만들어진 View가 없는 경우 레이아웃을 inflate하여 viewHolder를 생성

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(OrderListArrayList[position], position, context)

        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    } //layout의 view와 데이터를 연결

    override fun getItemCount(): Int {
        return OrderListArrayList.size
    }
} //아이템 갯수를 리턴처리하면 된다.