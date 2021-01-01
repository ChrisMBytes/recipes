package com.cmbytes.compose.recipes.presentation.store

import com.cmbytes.compose.presentation.store.Action
import com.cmbytes.compose.recipes.domain.models.Recipe

sealed class RecipesAction : Action() {
    data class Update(val recipes: List<Recipe>): RecipesAction()
}