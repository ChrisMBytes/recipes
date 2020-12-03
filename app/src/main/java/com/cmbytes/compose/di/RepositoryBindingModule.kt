package com.cmbytes.compose.di

import com.cmbytes.compose.domain.repositories.RecipesRepository
import com.cmbytes.compose.repository.RecipesRepositoryImpl
import dagger.Binds
import dagger.Module

@Module(includes = [RecipesNetworkModule::class])
internal interface RepositoryBindingModule {

    @Binds
    fun provideRecipesRepository(
        recipesRepositoryImpl: RecipesRepositoryImpl
    ): RecipesRepository
}