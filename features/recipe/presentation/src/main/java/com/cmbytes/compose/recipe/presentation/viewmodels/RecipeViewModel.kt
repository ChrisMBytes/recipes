package com.cmbytes.compose.recipe.presentation.viewmodels

import com.cmbytes.compose.recipe.presentation.store.RecipeState

interface RecipeViewModel {

    val recipeState: RecipeState

    fun load(recipeId: Int)
}