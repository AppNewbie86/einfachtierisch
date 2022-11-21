package com.modul3.einfachtierisch.data.models

data class NewsArticle(
    val id: Int,
    val title: String,
    val imageResourceId: Int,
    val location: String,
    val date: String,
    val article: String,
)