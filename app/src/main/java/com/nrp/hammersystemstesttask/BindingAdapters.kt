package com.nrp.hammersystemstesttask

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nrp.hammersystemstesttask.adapter.FoodItemAdapter
import com.nrp.hammersystemstesttask.model.Pizza

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.image_pending)
            error(R.drawable.the_cat_is_fat)
        }
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<Pizza>?) {
    val adapter = recyclerView.adapter as FoodItemAdapter
    adapter.submitList(data)
}

@BindingAdapter("foodApiStatus")
fun bindStatus(statusImageView: ImageView,
               status: FoodApiStatus?) {
    when (status) {
        FoodApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.image_pending)
        }
        FoodApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.the_cat_is_fat)
        }
        FoodApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}