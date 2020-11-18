package com.cmbytes.compose.di

import com.cmbytes.compose.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainBindings {

    @ContributesAndroidInjector(modules = [AppModule::class])
    abstract fun bindMainActivity(): MainActivity
}