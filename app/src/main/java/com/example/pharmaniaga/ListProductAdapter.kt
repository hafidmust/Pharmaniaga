package com.example.pharmaniaga

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmaniaga.model.Product

class ListProductAdapter(private val listProduct : ArrayList<Product>) : RecyclerView.Adapter<ListProductAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback : OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data : Product)
    }

    fun setOnItemClickCallback(onItemClickCallback : OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto : ImageView = itemView.findViewById(R.id.img_product)
        var tvName : TextView = itemView.findViewById(R.id.name_product)
        var tvDescription : TextView = itemView.findViewById(R.id.description_product)
        var tvPrice : TextView = itemView.findViewById(R.id.price_product)
        var cardview : CardView = itemView.findViewById(R.id.cv_products)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_products, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, price, photo) = listProduct[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.tvPrice.text = price
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listProduct[position])

        }
    }

    override fun getItemCount(): Int = listProduct.size
}