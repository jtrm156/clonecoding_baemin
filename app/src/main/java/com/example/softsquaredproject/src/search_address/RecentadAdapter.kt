package com.example.softsquaredproject.src.search_address

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.softsquaredproject.databinding.AddressListBinding
import com.example.softsquaredproject.databinding.RecentListBinding
import com.example.softsquaredproject.src.map.Map2Activity
import com.example.softsquaredproject.src.map.addrlist

class RecentadAdapter(private val context: Context, var addr2ArrayList: MutableList<addrlist2>) :
    RecyclerView.Adapter<RecentadAdapter.ItemViewHolder>() {
    //Layout들과 RecyclerView를 연결시킬 Adapter(데이터를 받아오고 이를 레이아웃에 직접 연결하는 함수를 실행시키는 클래스)

    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }
    private lateinit var itemClickListener: ItemClickListener

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    inner class ItemViewHolder(private val binding: RecentListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(addrlist2: addrlist2, num: Int, context: Context) {

            binding.map2Txt0.text = addrlist2.jAddr2
            binding.map2Txt3.text = addrlist2.rAddr2
            binding.map2Txt4.text = addrlist2.fAddr2
            binding.map2Txt5.text = addrlist2.fAddr2
            binding.map2Img1.setOnClickListener(){
                addr2ArrayList.removeAt(position)
                notifyItemRemoved(position)
                notifyDataSetChanged()
            }
        }

    } //ViewHolder는 클래스 내에 View를 저장하는 변수를 만들어 그 안에 데이터를 직접 연결시킬 수 있는 클래스, 디자인 패턴

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = RecentListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    } //화면을 최초 로딩하여 만들어진 View가 없는 경우 레이아웃을 inflate하여 viewHolder를 생성

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(addr2ArrayList[position], position, context)

        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    } //layout의 view와 데이터를 연결

    override fun getItemCount(): Int {
        return addr2ArrayList.size
    }
} //아이템 갯수를 리턴처리하면 된다.