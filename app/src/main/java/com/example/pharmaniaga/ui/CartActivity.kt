package com.example.pharmaniaga.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmaniaga.R
import com.example.pharmaniaga.model.Cart

class CartActivity : AppCompatActivity() {
    private lateinit var listCart : ArrayList<Cart>
    private lateinit var rvCart : RecyclerView

    val list : ArrayList<Cart> = arrayListOf(
        Cart(
            "Makanan 1",
            1,
            "16oz",
            "add extra sauce",
            "Rp 30,99",
            R.drawable.food1
        ),
        Cart(
            "Makanan 1",
            1,
            "16oz",
            "add extra sauce",
            "Rp 30,99",
            R.drawable.food1
        ),


        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        rvCart = findViewById(R.id.rv_cart)
        rvCart.setHasFixedSize(true)
        listCart = ArrayList<Cart>()
        listCart.addAll(list)
        showRecyclerListCart()
        val btnCart = findViewById<Button>(R.id.btn_cart)
        btnCart.setOnClickListener {
            showBottomSheet()
        }
    }

    private fun showBottomSheet() {
        val bottomSheetCartFragment = BottomSheetCartFragment()
        bottomSheetCartFragment.show(supportFragmentManager, BottomSheetCartFragment.TAG)
    }

    private fun showRecyclerListCart() {
        rvCart.layoutManager = LinearLayoutManager(this)
        val listCartAdapter = ListCartAdapter(listCart)
        rvCart.adapter = listCartAdapter
    }
}