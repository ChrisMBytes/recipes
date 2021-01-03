package com.cmbytes.compose.recipes.presentation.viewmodels

import com.cmbytes.compose.recipes.domain.models.Recipe

interface RecipesViewModel {

    val recipes: List<Recipe>
}