package com.github.outerheavenproject.wanstagram.ui

import android.content.Context
import com.github.outerheavenproject.wanstagram.ui.detail.DetailActivity

interface AppNavigator {
    fun navigateToDetail(imageUrl: String)
}

class AppNavigatorImpl(private val context: Context) : AppNavigator {
    override fun navigateToDetail(imageUrl: String) {
        context.startActivity(DetailActivity.createIntent(context, imageUrl))
    }
}
