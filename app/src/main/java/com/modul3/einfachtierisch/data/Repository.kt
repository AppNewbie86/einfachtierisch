package com.modul3.einfachtierisch.data

import android.content.ContentValues
import android.graphics.Picture
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.modul3.einfachtierisch.R
import com.modul3.einfachtierisch.data.models.*
import com.modul3.einfachtierisch.remote.DogApi
import kotlinx.coroutines.delay

class Repository(private val api: DogApi) {

    // Die Variable contactList ruft einmal die Funktion loadContacts() auf und speichert das Ergebnis
    private val _contactList = MutableLiveData<List<Contact>>(loadContacts())
    val contactList: LiveData<List<Contact>>
        get() = _contactList


    private val _dogs = MutableLiveData<List<Dogs>>()
    val dogs: LiveData<List<Dogs>>
        get() = _dogs

    suspend fun getDogs() {
        try {
            val data = api.retrofitService.getDogs(amount = 5)
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
            Contact("Brad", R.drawable.baxter, mutableListOf()),
            Contact("Emma", R.drawable.american, mutableListOf()),
            Contact("Jennifer", R.drawable.sales, mutableListOf()),
            Contact("Johnny", R.drawable.sourcer, mutableListOf()),
            Contact("Keanu", R.drawable.square, mutableListOf()),

            )
    }

    private fun loadHotStuff(): List<HotStuff> {
        return listOf(
            HotStuff("Brad", R.drawable.imageone),
            HotStuff("Emma", R.drawable.imagetwo),
            HotStuff("Jennifer", R.drawable.imagethree),
            HotStuff("Johnny", R.drawable.imagefour),
            HotStuff("Keanu", R.drawable.imagefive),
            HotStuff("Keanu", R.drawable.imagesix),
            HotStuff("Keanu", R.drawable.imageeight),
            HotStuff("Keanu", R.drawable.imagenine),


            )
    }


}






