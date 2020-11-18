package com.cmbytes.compose.di

import com.cmbytes.compose.configs.HttpConfigProvider
import com.cmbytes.compose.network.configs.HttpConfig
import dagger.Module
import dagger.Provides

@Module
object ConfigModule {

    @Provides
    fun providesHttpConfig(): HttpConfig = HttpConfigProvider()
}