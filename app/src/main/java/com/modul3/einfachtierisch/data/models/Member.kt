package com.modul3.einfachtierisch.data.models

import com.google.firebase.firestore.DocumentId


data class Member(

    @DocumentId

    val id: String = "",
    val name: String = "",


    val level: String = "Newbie"




)
