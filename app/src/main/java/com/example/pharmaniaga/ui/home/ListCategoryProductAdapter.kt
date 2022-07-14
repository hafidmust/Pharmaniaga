package com.example.pharmaniaga.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmaniaga.R
import com.example.pharmaniaga.model.Categorys

class ListCategoryProductAdapter(private val dataCategory : ArrayList<Categorys>) : RecyclerView.Adapter<ListCategoryProductAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sizeCategory : TextView
        val descCategory : TextView
        val priceCategory : TextView
        init {
            sizeCategory = itemView.findViewById(R.id.item_cat_size)
            descCategory = itemView.findViewById(R.id.item_cat_desc)
            priceCategory = itemView.findViewById(R.id.item_cat_price)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.sizeCategory.text = dataCategory[position].size
        holder.descCategory.text = dataCategory[position].description
        holder.priceCategory.text = dataCategory[position].price
    }

    override fun getItemCount(): Int = dataCategory.size
}