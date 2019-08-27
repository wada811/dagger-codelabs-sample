package com.github.outerheavenproject.wanstagram

import android.content.Context
import com.github.outerheavenproject.wanstagram.ui.AppNavigator
import com.github.outerheavenproject.wanstagram.ui.MainActivity
import com.github.outerheavenproject.wanstagram.ui.dogaction.DogActionSink

class MainActivityModule(private val context: Context) {
    fun getDogActionSink(activity: MainActivity): DogActionSink {
        return activity.presenter
    }

    fun appNavigator(activity: MainActivity): AppNavigator {
        return activity.createNavigator(context)
    }
}