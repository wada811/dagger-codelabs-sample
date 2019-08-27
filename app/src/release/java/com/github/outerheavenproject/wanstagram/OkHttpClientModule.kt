package com.github.outerheavenproject.wanstagram

import okhttp3.OkHttpClient

class OkHttpClientModule {
    val okHttpClient by lazy {
        OkHttpClient.Builder().build()
    }
}