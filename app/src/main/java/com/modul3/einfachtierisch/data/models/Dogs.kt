package com.modul3.einfachtierisch.data.models

data class Dogs(
    val id: Int,
    val name: String,
    val image: String,
    val coat_lenght: String,

    //entferne ich imageressourceId geht der recycler mit api
   // val imageResourceId: Int,
    val coat_color: String,
    val height: String,
    val detail_text: String
)