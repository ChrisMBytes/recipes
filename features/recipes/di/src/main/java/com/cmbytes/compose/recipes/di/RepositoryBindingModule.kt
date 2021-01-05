package com.cmbytes.compose.recipes.di

import com.cmbytes.compose.recipes.domain.repositories.RecipesRepository
import com.cmbytes.compose.recipes.repository.RecipesRepositoryImpl
import dagger.Binds
import dagger.Module

@Module(includes = [RecipesNetworkModule::class])
internal interface RepositoryBindingModule {

    @Binds
    fun provideRecipesRepository(
        recipesRepositoryImpl: RecipesRepositoryImpl
    ): RecipesRepository
}