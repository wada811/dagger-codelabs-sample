package com.github.outerheavenproject.wanstagram

import android.content.Context
import com.github.outerheavenproject.wanstagram.ui.AppNavigator
import com.github.outerheavenproject.wanstagram.ui.MainActivity

class MainActivityModule(private val context: Context) {
    fun appNavigator(activity: MainActivity): AppNavigator {
        return activity.appNavigator(context)
    }
}