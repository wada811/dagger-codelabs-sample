package com.github.outerheavenproject.wanstagram.data

class DogRepository(
    private val dogService: DogService
) {
    companion object {
        private const val LIMIT = 20
    }

    private var dogs: Dogs? = null

    suspend fun findAll(): Dogs {
        dogs?.let { return it }
        return dogService.getDogs(LIMIT)
            .also { dogs = it }
    }
}