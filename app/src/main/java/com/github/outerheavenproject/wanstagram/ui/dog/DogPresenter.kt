package com.github.outerheavenproject.wanstagram.ui.dog

import com.github.outerheavenproject.wanstagram.data.DogService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogPresenter(
    private val view: DogContract.View,
    private val dogService: DogService
) : DogContract.Presenter {
    override suspend fun start() {
        val dogs = dogService.getDogs(limit = 20)
        withContext(Dispatchers.Main) {
            view.updateDogs(dogs)
        }
    }
}
