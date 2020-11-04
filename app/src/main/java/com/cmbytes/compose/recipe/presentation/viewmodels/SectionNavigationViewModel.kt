package com.cmbytes.compose.recipe.presentation.viewmodels

import com.cmbytes.compose.recipe.presentation.navigation.Section

interface SectionNavigationViewModel {

    val section: Section

    fun navigateTo(section: Section)
}