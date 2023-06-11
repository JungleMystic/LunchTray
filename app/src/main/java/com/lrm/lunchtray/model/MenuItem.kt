package com.lrm.lunchtray.model

import java.text.NumberFormat

data class MenuItem(
    val name: String,
    val description: String,
    val price: Int,
    val type: Int,
    val code: String
) {
    fun getFormattedPrice(): String = "₹ $price"
}
