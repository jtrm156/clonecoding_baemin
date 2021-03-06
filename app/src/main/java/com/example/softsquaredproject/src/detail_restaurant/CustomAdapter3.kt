package com.example.softsquaredproject.src.detail_restaurant

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.example.softsquaredproject.databinding.MenuList2Binding
import com.example.softsquaredproject.databinding.MenuListBinding
import com.example.softsquaredproject.databinding.RestaurantListItemBinding
import com.example.softsquaredproject.src.basket.BasketActivity
import com.example.softsquaredproject.src.order.restaurantList

class CustomAdapter3(private val context: Context, var RestaurantArrayList: MutableList<menuList>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    //Layout들과 RecyclerView를 연결시킬 Adapter(데이터를 받아오고 이를 레이아웃에 직접 연결하는 함수를 실행시키는 클래스)
    private val VIEW_TYPE_ITEM = 1
    private val VIEW_TYPE_LOADING = 0

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
            //binding.menuListTxt2.text = menulist.menuNm
            //binding.menuListTxt3.text = "${menulist.price}원"
            //if (menulist.isReprsnMenu == "N") binding.menuListTxt4.visibility = View.GONE
            //Glide.with(itemView).load(menulist.menu_url_img).diskCacheStrategy(
            //    DiskCacheStrategy.RESOURCE).fitCenter().into(binding.menuListImg1)

        }
    } //ViewHolder는 클래스 내에 View를 저장하는 변수를 만들어 그 안에 데이터를 직접 연결시킬 수 있는 클래스, 디자인 패턴

    inner class ItemView2Holder(private val binding: MenuList2Binding) :
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
            binding.menuListTxt2.text = menulist.menuNm
            binding.menuListTxt3.text = "${menulist.price}원"

            if (menulist.isReprsnMenu == "Y" && menulist.isHot == "Y"){
                binding.menuListTxt4.visibility = View.VISIBLE
                binding.menuListTxt5.visibility = View.GONE
            }
            if (menulist.isHot == "Y" && menulist.isReprsnMenu == "N" ){
                binding.menuListTxt4.visibility = View.GONE
                binding.menuListTxt5.visibility = View.VISIBLE
            }

            if(menulist.isHot == "N" && menulist.isReprsnMenu == "N"){
                binding.menuListTxt4.visibility = View.GONE
                binding.menuListTxt5.visibility = View.GONE
            }
            Glide.with(itemView).load(menulist.menu_url_img).diskCacheStrategy(
                DiskCacheStrategy.RESOURCE).fitCenter().into(binding.menuListImg1)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            VIEW_TYPE_LOADING -> {
                val binding = MenuListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ItemViewHolder(binding)
            }

            VIEW_TYPE_ITEM -> {
                val binding = MenuList2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                ItemView2Holder(binding)
            }

            else -> {
                val binding = MenuListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ItemViewHolder(binding)
            }
        }
    } //화면을 최초 로딩하여 만들어진 View가 없는 경우 레이아웃을 inflate하여 viewHolder를 생성

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ItemViewHolder) {
            holder.bind(RestaurantArrayList[position], position, context)
        }
        else if(holder is ItemView2Holder){
            holder.bind(RestaurantArrayList[position], position, context)
        }
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
            val intent = Intent(holder.itemView?.context, BasketActivity::class.java)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    } //layout의 view와 데이터를 연결

    override fun getItemCount(): Int {
        return RestaurantArrayList.size
    }

    override fun getItemViewType(position: Int): Int {
        // 게시물과 프로그레스바 아이템뷰를 구분할 기준이 필요하다.
        return when (RestaurantArrayList[position].group) {
            0 -> VIEW_TYPE_LOADING
            1 -> VIEW_TYPE_ITEM
            else -> VIEW_TYPE_LOADING
        }
    }
} //아이템 갯수를 리턴처리하면 된다.