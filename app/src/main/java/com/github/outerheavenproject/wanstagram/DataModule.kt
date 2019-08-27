package com.github.outerheavenproject.wanstagram

import com.github.outerheavenproject.wanstagram.data.DogService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create

class DataModule {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(
                Json.asConverterFactory("application/json".toMediaType())
            )
            .build()
    }
    val dogService: DogService by lazy {
        retrofit.create() as DogService
    }
}