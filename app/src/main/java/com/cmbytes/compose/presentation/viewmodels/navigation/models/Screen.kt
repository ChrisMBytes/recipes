package com.cmbytes.compose.presentation.viewmodels.navigation.models

sealed class Screen {
    object Home: Screen()
    data class Detail(val recipeId: Int): Screen()
}