package com.modul3.einfachtierisch.data

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.modul3.einfachtierisch.R
import com.modul3.einfachtierisch.data.models.Contact
import com.modul3.einfachtierisch.data.models.Dogs
import com.modul3.einfachtierisch.data.models.HotStuff
import com.modul3.einfachtierisch.remote.DogApi

class Repository(private val api: DogApi) {


    // Die Variable contactList ruft einmal die Funktion loadContacts() auf und speichert das Ergebnis
    private val _contactList = MutableLiveData<List<Contact>>(loadContacts() as List<Contact>?)
    val contactList: LiveData<List<Contact>>
        get() = _contactList


    private val _dogs = MutableLiveData<List<Dogs>>()
    val dogs: LiveData<List<Dogs>>
        get() = _dogs

    suspend fun getDogs() {
        try {
            val data = api.retrofitService.getDogs()
            _dogs.value = data
        } catch (e: Exception) {
            Log.e(ContentValues.TAG, "Error loading Dog from API: $e")
        }
    }


    /**
     * Diese Funktion gibt eine Liste aus Contact Objekten zurück.
     * Jedes Contact Objekt enthält die Informationen für den Namen und
     * die Bild Ressource und eine leere veränderliche Liste
     */

    private fun loadContacts(): List<Contact> {
        return listOf(
            Contact("Petty", R.drawable.sourcer, mutableListOf()),
            Contact("Olaf_DogTrainer", R.drawable.sales, mutableListOf()),
            Contact("Administrator", R.drawable.square, mutableListOf()),
            Contact("alterHase89", R.drawable.american, mutableListOf()),

        )
    }





fun loadHotStuff(): List<HotStuff> {

    return listOf(
        HotStuff(
            1,
            "Die Top Social Media Party des Jahres !!!",
            R.drawable.imageone,
            "Deutschland",
            "23.12.2022",
            "auchtung achtung!\nNur begrenzte Plätze buchbar," +
                    "jetzt schnell Plätze sichern solange der Vorrat reicht"
        ),
        HotStuff(
            1,
            "Eine kleine und doch jedes jahr mehr Achtung geschenkt wird ist unsere DogSpezialChristmasParty",
            R.drawable.imagetwo,
            "Deutschland",
            "19.12.2022",
            "extra mit KinderProgramm\nund vielem mehr"
        ),

        HotStuff(
            1,
            "Die Top 10 gefährlichsten Tiere Deutschlands!",
            R.drawable.imagethree,
            "Deutschland",
            "23.06.2022",
            "auchtung achtung!\nDie fressen dich"
        ),
        HotStuff(
            1,
            "Die Top 10 gefährlichsten Tiere Deutschlands!",
            R.drawable.imagefour,
            "Deutschland",
            "23.06.2022",
            "auchtung achtung!\nDie fressen dich"
        ),
        HotStuff(
            1,
            "Die Top 10 gefährlichsten Tiere Deutschlands!",
            R.drawable.imagefive,
            "Deutschland",
            "23.06.2022",
            "auchtung achtung!\nDie fressen dich"
        ),
    )
}}









