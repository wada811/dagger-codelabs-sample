package com.github.outerheavenproject.wanstagram

import android.content.Context
import com.github.outerheavenproject.wanstagram.ui.AppNavigator
import com.github.outerheavenproject.wanstagram.ui.AppNavigatorImpl

class AppComponent {
    private val okHttpClientModule by lazy {
        OkHttpClientModule()
    }
    val dataModule by lazy {
        DataModule(okHttpClientModule)
    }
    val appNavigator: (Context) -> AppNavigator by lazy {
        return@lazy { context: Context -> AppNavigatorImpl(context) }
    }

    fun createMainActivitySubcomponent(context: Context): MainActivitySubcomponent {
        return MainActivitySubcomponent(context)
    }
}
