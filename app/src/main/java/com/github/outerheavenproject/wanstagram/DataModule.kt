package com.github.outerheavenproject.wanstagram

import com.github.outerheavenproject.wanstagram.data.DogRepository
import com.github.outerheavenproject.wanstagram.data.DogService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create

class DataModule(okHttpClientModule: OkHttpClientModule) {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(
                Json.asConverterFactory("application/json".toMediaType())
            )
            .client(okHttpClientModule.okHttpClient)
            .build()
    }
    val dogService: DogService by lazy {
        retrofit.create() as DogService
    }
    val dogRepository: DogRepository by lazy {
        DogRepository(dogService)
    }
}