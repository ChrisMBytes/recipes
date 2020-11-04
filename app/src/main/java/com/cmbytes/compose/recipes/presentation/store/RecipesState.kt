package com.cmbytes.compose.recipes.presentation.store

import com.cmbytes.compose.domain.models.Recipe
import com.cmbytes.compose.presentation.store.UiState

data class RecipesState(val recipes: List<Recipe>) : UiState()