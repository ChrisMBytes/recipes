package com.cmbytes.compose.presentation.proxy

import com.cmbytes.compose.recipe.presentation.store.RecipeAction
import com.cmbytes.compose.recipe.presentation.store.RecipeState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow

interface RecipesProxy {

    @OptIn(ExperimentalCoroutinesApi::class)
    val state: StateFlow<RecipeState>

    suspend fun dispatch(recipeAction: RecipeAction)
}