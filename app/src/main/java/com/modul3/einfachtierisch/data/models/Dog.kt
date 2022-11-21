package com.modul3.einfachtierisch.data.models


data class Dog(
    val id: Int,
    val name: String,
    val imageRes: Int,
    val dogHistory: MutableList<String>

)
