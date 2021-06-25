package com.surgatutorial.latihanrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.surgatutorial.latihanrecyclerview.databinding.FoodListBinding

class FoodAdapter(private val listFood: List<Food>) : RecyclerView.Adapter<FoodAdapter.FoodHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): FoodHolder {
        val binding = FoodListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return FoodHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {
        holder.bind(listFood[position])
    }

    override fun getItemCount(): Int = listFood.size


    inner class FoodHolder(private val binding: FoodListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Food) {
            with(binding){
                Glide.with(itemView.context)
                    .load(food.image)
                    .apply(RequestOptions().override(70, 70))
                    .into(imgFood)

                tvName.text = food.name
                tvTime.text = food.time

                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(food) }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(food: Food)
    }
}