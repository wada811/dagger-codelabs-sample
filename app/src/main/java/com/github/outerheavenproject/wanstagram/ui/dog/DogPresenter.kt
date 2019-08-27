package com.github.outerheavenproject.wanstagram.ui.dog

import com.github.outerheavenproject.wanstagram.data.DogRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogPresenter(
    private val view: DogContract.View,
    private val repository: DogRepository
) : DogContract.Presenter {
    override suspend fun start() {
        val dogs = repository.findAll()
        withContext(Dispatchers.Main) {
            view.updateDogs(dogs)
        }
    }
}
