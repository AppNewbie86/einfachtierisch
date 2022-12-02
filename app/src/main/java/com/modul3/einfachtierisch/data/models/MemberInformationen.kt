package com.modul3.einfachtierisch.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class MemberInformationen(

    @PrimaryKey
    val id: Int = 0,
    val fullName: String = "",
    val dogName: String = "",
    val age: Int = 1,
    val livingPerson: Int = 1,
    val timeDate: String = "",
    val personalityPosition: String = "",
    val expirience: String = "",
    val job: String = "",
    val myName: String,
    val myAge: String,
    val myDogName: String,
    val livingPers: String
)