package com.example.softsquaredproject.src.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.softsquaredproject.R
import com.example.softsquaredproject.databinding.FoodcategoryListLtemBinding

class CustomAdapter(private val context: Context, var FoodcategoryArrayList: MutableList<Foodcategory>) :
    RecyclerView.Adapter<CustomAdapter.ItemViewHolder>() {
    //Layout들과 RecyclerView를 연결시킬 Adapter(데이터를 받아오고 이를 레이아웃에 직접 연결하는 함수를 실행시키는 클래스)

    interface ItemClickListener {
        fun onClick(view: View, position: Int)
        fun onLongClick(view: View, position: Int)
    }
    private lateinit var itemClickListener: ItemClickListener

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    inner class ItemViewHolder(private val binding: FoodcategoryListLtemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(foodcategory: Foodcategory, num: Int, context: Context) {

            val resourceId = context.resources.getIdentifier(
                foodcategory.img.toString(),
                "drawable",
                context.packageName
            )
            binding.foodcategoryImage.setImageResource(resourceId)
            binding.foodcategoryText.text = foodcategory.category_name
        }

    } //ViewHolder는 클래스 내에 View를 저장하는 변수를 만들어 그 안에 데이터를 직접 연결시킬 수 있는 클래스, 디자인 패턴

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = FoodcategoryListLtemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    } //화면을 최초 로딩하여 만들어진 View가 없는 경우 레이아웃을 inflate하여 viewHolder를 생성

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(FoodcategoryArrayList[position], position, context)

        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    } //layout의 view와 데이터를 연결

    override fun getItemCount(): Int {
        return FoodcategoryArrayList.size
    }
} //아이템 갯수를 리턴처리하면 된다.