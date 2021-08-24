package com.example.softsquaredproject.src.detail_restaurant

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.softsquaredproject.databinding.MenuListBinding
import com.example.softsquaredproject.databinding.RestaurantListItemBinding
import com.example.softsquaredproject.src.basket.BasketActivity
import com.example.softsquaredproject.src.order.restaurantList

class CustomAdapter3(private val context: Context, var RestaurantArrayList: MutableList<menuList>) :
    RecyclerView.Adapter<CustomAdapter3.ItemViewHolder>() {
    //Layout들과 RecyclerView를 연결시킬 Adapter(데이터를 받아오고 이를 레이아웃에 직접 연결하는 함수를 실행시키는 클래스)

    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }
    private lateinit var itemClickListener: ItemClickListener

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    inner class ItemViewHolder(private val binding: MenuListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(menulist: menuList, num: Int, context: Context) {

            /*
            val resourceId = context.resources.getIdentifier(
                restaurantlist.img.toString(),
                "drawable",
                context.packageName
            )
            */


            //binding.restaurantImage.setImageResource(resourceId)

            binding.menuListTxt1.text = menulist.menuGrpNm
            binding.menuListTxt2.text = menulist.menuNm
            binding.menuListTxt3.text = "${menulist.price}원"
            if(menulist.isReprsnMenu == "N") binding.menuListTxt4.visibility = View.GONE
            Glide.with(itemView).load(menulist.menu_url_img).into(binding.menuListImg1)
        }

    } //ViewHolder는 클래스 내에 View를 저장하는 변수를 만들어 그 안에 데이터를 직접 연결시킬 수 있는 클래스, 디자인 패턴

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = MenuListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    } //화면을 최초 로딩하여 만들어진 View가 없는 경우 레이아웃을 inflate하여 viewHolder를 생성

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(RestaurantArrayList[position], position, context)

        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
            val intent = Intent(holder.itemView?.context, BasketActivity::class.java)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    } //layout의 view와 데이터를 연결

    override fun getItemCount(): Int {
        return RestaurantArrayList.size
    }
} //아이템 갯수를 리턴처리하면 된다.