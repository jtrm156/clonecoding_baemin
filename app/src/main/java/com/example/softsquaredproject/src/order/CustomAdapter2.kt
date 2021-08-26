package com.example.softsquaredproject.src.order

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.example.softsquaredproject.R
import com.example.softsquaredproject.config.ApplicationClass.Companion.sSharedPreferences
import com.example.softsquaredproject.databinding.RestaurantListItemBinding
import com.example.softsquaredproject.src.detail_restaurant.DetailActivity
import com.example.softsquaredproject.src.home.Foodcategory

class CustomAdapter2(private val context: Context, var RestaurantArrayList: MutableList<restaurantList>) :
    RecyclerView.Adapter<CustomAdapter2.ItemViewHolder>() {
    //Layout들과 RecyclerView를 연결시킬 Adapter(데이터를 받아오고 이를 레이아웃에 직접 연결하는 함수를 실행시키는 클래스)

    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }
    private lateinit var itemClickListener: ItemClickListener

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    inner class ItemViewHolder(private val binding: RestaurantListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(restaurantlist: restaurantList, num: Int, context: Context) {

            /*
            val resourceId = context.resources.getIdentifier(
                restaurantlist.img.toString(),
                "drawable",
                context.packageName
            )
            */


            //binding.restaurantImage.setImageResource(resourceId)

            Glide.with(itemView).load(restaurantlist.restaurant_img).error(R.drawable.baemin_category_icon6).into(binding.restaurantImage)
            binding.restaurantName.text = restaurantlist.restaurant_name
            binding.restaurantStar.text = restaurantlist.restaurant_star
            binding.restaurantReviewCnt.text = restaurantlist.restaurant_reviewCnt
            binding.restaurantMenu.text = restaurantlist.restaurant_menu
            binding.restaurantDelivertime.text = restaurantlist.restaurant_delivertime
            binding.restaurantDelivertip.text = "배달팁 0원~${restaurantlist.restaurant_delivertip}원"
            binding.restaurantOrderprice.text = "최소주문 ${restaurantlist.restaurant_orderprice}원"
            val coupon = restaurantlist.coupon % 3
            /*
            when(coupon){
                0 -> { binding.restaurantCoupon1.visibility = View.VISIBLE}
                1 -> binding.restaurantCoupon2.visibility = View.VISIBLE
                2 -> binding.restaurantCoupon3.visibility = View.VISIBLE
            }
            */
            if(coupon == 0){
                binding.restaurantCoupon1.visibility = View.VISIBLE
                binding.restaurantCoupon2.visibility = View.GONE
                binding.restaurantCoupon3.visibility = View.VISIBLE
            }
            else if(coupon == 1){
                binding.restaurantCoupon1.visibility = View.GONE
                binding.restaurantCoupon2.visibility = View.VISIBLE
                binding.restaurantCoupon3.visibility = View.GONE
            }
            else if(coupon == 2){
                binding.restaurantCoupon1.visibility = View.GONE
                binding.restaurantCoupon2.visibility = View.GONE
                binding.restaurantCoupon3.visibility = View.VISIBLE
            }
        }

    } //ViewHolder는 클래스 내에 View를 저장하는 변수를 만들어 그 안에 데이터를 직접 연결시킬 수 있는 클래스, 디자인 패턴

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = RestaurantListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    } //화면을 최초 로딩하여 만들어진 View가 없는 경우 레이아웃을 inflate하여 viewHolder를 생성

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(RestaurantArrayList[position], position, context)

        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
            val intent = Intent(holder.itemView?.context, DetailActivity::class.java)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    } //layout의 view와 데이터를 연결

    override fun getItemCount(): Int {
        return RestaurantArrayList.size
    }
} //아이템 갯수를 리턴처리하면 된다.