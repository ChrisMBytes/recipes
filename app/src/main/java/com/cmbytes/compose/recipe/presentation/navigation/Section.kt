package com.cmbytes.compose.recipe.presentation.navigation

sealed class Section(open val id: Int) {
    data class Ingredients(override val id: Int): Section(id)
    data class HowToCook(override val id: Int): Section(id)
}