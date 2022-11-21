package com.modul3.einfachtierisch.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.modul3.einfachtierisch.data.models.ApiResponse
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

/**
 * DOG API wo die HundeBilder zur Verfügung stellt
 */
const val BASE_URL = "https://dog.ceo/api/breed/hound/"
//https://dog.ceo/dog-api/
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface DogApiService {
    @GET("images")
    suspend fun getImages(): ApiResponse
}

object DogApi {
    val retrofitService: DogApiService by lazy { retrofit.create(DogApiService::class.java) }
}
