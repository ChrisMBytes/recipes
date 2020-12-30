package com.cmbytes.compose.di

import com.cmbytes.compose.configs.HttpConfigProvider
import com.cmbytes.compose.general.configs.HttpConfig
import dagger.Module
import dagger.Provides

@Module
object ConfigModule {

    @Provides
    fun providesHttpConfig(): HttpConfig = HttpConfigProvider()
}