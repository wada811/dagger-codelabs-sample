package com.github.outerheavenproject.wanstagram.ui.dog

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface DogFragmentModule {
    @ContributesAndroidInjector(
        modules = [
            DogFragmentModule::class
        ]
    )
    fun contributeDogFragment(): DogFragment
}
