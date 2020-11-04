package com.cmbytes.compose.presentation.navigation

sealed class Screen {
    object Home: Screen()
    data class Detail(val recipeId: Int): Screen()
}