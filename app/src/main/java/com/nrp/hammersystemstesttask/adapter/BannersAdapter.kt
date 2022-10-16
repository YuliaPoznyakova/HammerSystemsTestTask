package com.nrp.hammersystemstesttask.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.nrp.hammersystemstesttask.R

class BannersAdapter(
    private val context: Context,
    private val dataset: List<Int>
): RecyclerView.Adapter<BannersAdapter.BannersViewHolder>() {

    class BannersViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.banner_image)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BannersAdapter.BannersViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.banner_item, parent, false)
        return BannersViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: BannersAdapter.BannersViewHolder, position: Int) {
        val item = dataset[position]
        holder.imageView.setImageResource(item)
    }

    override fun getItemCount() = dataset.size
}