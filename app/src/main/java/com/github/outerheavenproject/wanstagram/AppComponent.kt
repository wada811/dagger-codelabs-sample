package com.github.outerheavenproject.wanstagram

class AppComponent {
    private val okHttpClientModule by lazy {
        OkHttpClientModule()
    }
    val dataModule by lazy {
        DataModule(okHttpClientModule)
    }

}
