package com.cmbytes.compose.di

import com.cmbytes.compose.domain.usecases.RecipesRepository
import com.cmbytes.compose.repository.RecipesRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
internal interface AppBindingModule {

    @Binds
    fun provideRecipesRepository(
        recipesRepositoryImpl: RecipesRepositoryImpl
    ): RecipesRepository
}