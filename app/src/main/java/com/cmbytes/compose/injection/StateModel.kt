package com.cmbytes.compose.injection

import com.cmbytes.compose.presentation.store.Reducer
import com.cmbytes.compose.recipe.presentation.store.RecipeAction
import com.cmbytes.compose.recipe.presentation.store.RecipeReducer
import com.cmbytes.compose.recipe.presentation.store.RecipeState
import com.cmbytes.compose.recipes.presentation.store.RecipesAction
import com.cmbytes.compose.recipes.presentation.store.RecipesReducer
import com.cmbytes.compose.recipes.presentation.store.RecipesState
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object StateModel {

    // Should be scoped to the Composes component
    @Singleton
    @Provides
    fun provideRecipesReducer(): Reducer<RecipesAction, RecipesState> = RecipesReducer()

    // Should be scoped to the Composes component
    @Singleton
    @Provides
    fun provideRecipeReducer(): Reducer<RecipeAction, RecipeState> = RecipeReducer()
}