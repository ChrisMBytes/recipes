package com.cmbytes.compose.di

import com.cmbytes.compose.domain.usecases.GetRecipes
import com.cmbytes.compose.domain.usecases.RecipesRepository
import dagger.Module
import dagger.Provides

@Module
object RecipesDomainModule {

    @Provides
    fun provideGetRecipes(
        recipesRepository: RecipesRepository
    ): GetRecipes = GetRecipes(recipesRepository)
}