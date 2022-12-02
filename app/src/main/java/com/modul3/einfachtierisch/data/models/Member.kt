package com.modul3.einfachtierisch.data.models

import com.google.firebase.firestore.DocumentId


data class Member(
    @DocumentId
    val id: String = "",
    val name: String = "",
    val level: Long = 1,
    val image: String = "",
    val myAge: Int = 1,
    val myDogName: String = "",
    val livingPerson: Int = 1,
    val timeDate: String = "",
    val personalityPosition: String = "",
    val expirience: String = "",
    val job: String = "",
)

