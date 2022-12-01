package com.modul3.einfachtierisch.data.models

import com.google.firebase.firestore.DocumentId

data class MemberInformationen
    (
@DocumentId
val age: Int = 1,
val expirience: String = "",
val favoriteColor: String = "",
val gen: String = ""
)