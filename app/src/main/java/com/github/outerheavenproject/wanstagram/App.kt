package com.github.outerheavenproject.wanstagram

import android.app.Application

class App : Application() {
    companion object {
        lateinit var Instance: App
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        Instance = this
        appComponent = AppComponent()
    }
}