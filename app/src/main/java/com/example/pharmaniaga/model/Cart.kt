package com.example.pharmaniaga.model

data class Cart(
    val name : String,
    val totalOrder : Int,
    val size : String? = null,
    val notes : String? = null,
    val price : String,
    val image : Int
)
