package de.syntaxinstitut.dogCround.data.datamodels

import com.squareup.moshi.Json


data class ApiResponse(
    @Json(name = "message")
    val images: List<String>
)
