package com.modul3.einfachtierisch.data.models

//VORGEHENSWEISE DATEN VON FIREBASE IN APP ANZEIGEN LASSEN

// DATA CLASS ERSTELLEN MIT NAME IMMER DEN DOKUMENTID MIT @ HINZUFÜGEN
// BENÖTIGTEN EIGENSCHAFTEN MITGEBEN

//ID
//tip


data class TipDesTages(
    @DokumentId
    val id: String = "",
    val tip: String = "",
) {
    annotation class DokumentId
}