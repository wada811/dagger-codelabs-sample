package com.github.outerheavenproject.wanstagram

import android.content.Context

class MainActivitySubcomponent(context: Context) {
    val mainActivityModule by lazy {
        MainActivityModule(context)
    }
}