package com.cmbytes.compose.recipes.presentation.store

import com.cmbytes.compose.presentation.store.UiState
import com.cmbytes.compose.recipes.domain.models.Recipe

data class RecipesState(val recipes: List<Recipe>) : UiState()