package com.nrp.hammersystemstesttask.model

data class Pizza(
    val id: String,
    val img: String,
    val name: String,
    val dsc: String,
    val price: Float,
    val rate: Int,
    val country: String
)