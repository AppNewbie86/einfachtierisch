package de.syntaxinstitut.dogCround.data.datamodels


data class Dog(
    val id: Int,
    val name: String,
    val imageRes: Int,
    val dogHistory: MutableList<String>

)
