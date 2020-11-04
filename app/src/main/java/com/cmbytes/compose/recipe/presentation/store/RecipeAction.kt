package com.cmbytes.compose.recipe.presentation.store

import com.cmbytes.compose.presentation.store.Action

sealed class RecipeAction : Action() {
    data class Load(val recipeId: Int) : RecipeAction()
    data class Update(val recipe: RecipeState) : RecipeAction()
}