package com.nrp.hammersystemstesttask.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nrp.hammersystemstesttask.databinding.FoodItemBinding
import com.nrp.hammersystemstesttask.model.Pizza

class FoodItemAdapter():
    ListAdapter<Pizza, FoodItemAdapter.FoodItemViewHolder>(FoodItemViewHolder) {

    class FoodItemViewHolder(
        private var binding: FoodItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(food: Pizza) {
            binding.food = food
            binding.executePendingBindings()
            binding.foodName.text = food.name
            binding.foodImage.load(food.img)
            binding.foodDescription.text = food.dsc
            binding.foodPrice.text = food.price.toString()
        }

        companion object DiffCallback : DiffUtil.ItemCallback<Pizza>() {
            override fun areItemsTheSame(oldItem: Pizza, newItem: Pizza): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Pizza, newItem: Pizza): Boolean {
                return oldItem.img == newItem.img
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FoodItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FoodItemViewHolder(
            FoodItemBinding.inflate(
                layoutInflater,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FoodItemViewHolder, position: Int) {
        val food = getItem(position)
        holder.bind(food)
    }
}
