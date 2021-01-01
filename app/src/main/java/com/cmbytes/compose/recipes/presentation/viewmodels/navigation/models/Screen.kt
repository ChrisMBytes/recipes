package com.cmbytes.compose.recipes.presentation.viewmodels.navigation.models

sealed class Screen {
    object Home: Screen()
    data class Detail(val recipeId: Int): Screen()
}