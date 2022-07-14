package com.example.pharmaniaga.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pharmaniaga.R
import com.example.pharmaniaga.model.Cart

class ListCartAdapter(private val listCart : ArrayList<Cart>) : RecyclerView.Adapter<ListCartAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imagePhoto : ImageView = itemView.findViewById(R.id.img_product)
        var tvTotalOrder : TextView = itemView.findViewById(R.id.total_order)
        var tvNameCart : TextView = itemView.findViewById(R.id.item_name)
        var tvSize : TextView = itemView.findViewById(R.id.item_size)
//        var tvNotes : TextView = itemView.findViewById(R.id.item_notes)
        var price : TextView = itemView.findViewById(R.id.item_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (name, totalOrder, size, notes, priceCart, image) = listCart[position]
//        holder.imagePhoto.setImageResource(image)
        Glide.with(holder.itemView).load(image).into(holder.imagePhoto)
        holder.tvTotalOrder.text = "x$totalOrder"
        holder.tvNameCart.text = name
        holder.tvSize.text = size
//        holder.tvSize.text = size
        holder.price.text = priceCart.toString()

    }

    override fun getItemCount(): Int = listCart.size

}