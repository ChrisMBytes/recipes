package com.cmbytes.compose.recipe.presentation.store

import com.cmbytes.compose.recipes.domain.models.Recipe
import com.cmbytes.compose.presentation.store.UiState

sealed class RecipeState : UiState() {
    data class CurrentRecipe(val recipe: Recipe) : RecipeState()
    object Loading : RecipeState()
    object Error : RecipeState()
}