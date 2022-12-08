package com.modul3.einfachtierisch.data.models

/**
 * Die Datenklasse Hunde kommunziert mit der API und kann
 * dort die Parameter ansteuern und die Informationen erhalten
 *
 */

data class Dogs(
    val id: Int,                                    // HundeId
    val name: String,                               // Hundename
    val image: String,                              // HundeBild
    val coat_lenght: String,                        // Haarlänge
    val coat_color: String,                         // Haarfarbe
    val height: String,                             // HundeHöhe
    val detail_text: String                         // Hundebschreibungstext
)