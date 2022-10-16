package com.nrp.hammersystemstesttask.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nrp.hammersystemstesttask.R

class CategoryAdapter(
    private val context: Context,
    private val dataset: List<Int>
): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.category_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_item, parent, false)
        return CategoryViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item)
    }

    override fun getItemCount() = dataset.size
}