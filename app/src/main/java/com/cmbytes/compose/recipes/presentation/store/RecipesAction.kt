package com.cmbytes.compose.recipes.presentation.store

import com.cmbytes.compose.domain.models.Recipe
import com.cmbytes.compose.presentation.store.Action

sealed class RecipesAction : Action() {
    data class Update(val recipes: List<Recipe>): RecipesAction()
}