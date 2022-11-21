package com.modul3.einfachtierisch.data.models

import com.squareup.moshi.Json


data class ApiResponse(
    @Json(name = "message")
    val images: List<String>
)
