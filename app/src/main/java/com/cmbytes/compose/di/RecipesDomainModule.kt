package com.cmbytes.compose.di

import com.cmbytes.compose.recipes.domain.usecases.GetRecipes
import com.cmbytes.compose.recipes.domain.repositories.RecipesRepository
import dagger.Module
import dagger.Provides

@Module(includes = [RepositoryBindingModule::class])
object RecipesDomainModule {

    @Provides
    fun provideGetRecipes(
        recipesRepository: RecipesRepository
    ): GetRecipes = GetRecipes(recipesRepository)
}