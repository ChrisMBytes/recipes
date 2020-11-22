package com.cmbytes.compose.presentation.proxy

import com.cmbytes.compose.recipe.presentation.store.RecipeAction
import com.cmbytes.compose.recipe.presentation.store.RecipeState
import kotlinx.coroutines.flow.StateFlow

interface RecipesProxy {

    val state: StateFlow<RecipeState>

    suspend fun dispatch(recipeAction: RecipeAction)
}