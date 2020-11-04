package com.cmbytes.compose.recipes.presentation.viewmodels

import com.cmbytes.compose.domain.models.Recipe

interface RecipesViewModel {

    val recipes: List<Recipe>
}