package com.github.outerheavenproject.wanstagram.ui.shiba

import com.github.outerheavenproject.wanstagram.data.DogService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ShibaPresenter(
    private val view: ShibaContract.View,
    private val dogService: DogService
) : ShibaContract.Presenter {
    override suspend fun start() {
        val dogs = dogService.getBleed(bleed = "shiba", limit = 20)
        withContext(Dispatchers.Main) {
            view.updateDogs(dogs)
        }
    }
}
