package com.modul3.einfachtierisch.remote

import com.modul3.einfachtierisch.data.models.Dogs
import com.squareup.moshi.Moshi.Builder
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

/**
 * DOG API wo die HundeBilder zur Verfügung stellt
 * Stellt eine Verbindung zur Libary her
 * Get kommt das wort nach dem Slash
 * Query wird das limit angeben
 * Und haben gesagt wie ein Objekt aussehen soll
 */

const val BASE_URL = "https://public.syntax-institut.de/apps/batch2/AndreLuft/"

private val moshi = Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {

    @GET("data.json")
    suspend fun getDogs(): List<Dogs>


}

object DogApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}