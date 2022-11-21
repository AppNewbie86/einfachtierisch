package com.modul3.einfachtierisch.data.models

import com.google.firebase.firestore.DocumentId


data class Request(

@DocumentId
    var requestId: Int = 0,

    var name: String = "",
    var requestarten: String = "",
    var title: String = "",
    var requestText: String = "",
    var userId: Int = 0


    )
