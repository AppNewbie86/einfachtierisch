package com.modul3.einfachtierisch.data.models

/**
 * Diese Data Klasse steht für einen einzelnen Kontakt im NotificationsFragment
 * @param name der Name des Kontakts
 * @param imageResId die resource ID des Bildes des Kontakts
 * @param chatHistory eine Liste aus Message Objekten, in der der Chat Verlauf gespeichert ist
 */
data class Contact(
    val name: String,
    val imageResId: Int,
    val chatHistory: MutableList<Message>
)
