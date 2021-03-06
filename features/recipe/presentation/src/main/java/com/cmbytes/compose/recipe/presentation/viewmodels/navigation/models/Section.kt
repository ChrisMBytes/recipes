package com.cmbytes.compose.recipe.presentation.viewmodels.navigation.models

sealed class Section(open val id: Int) {
    data class Ingredients(override val id: Int = 0): Section(id)
    data class HowToCook(override val id: Int = 1): Section(id)
}