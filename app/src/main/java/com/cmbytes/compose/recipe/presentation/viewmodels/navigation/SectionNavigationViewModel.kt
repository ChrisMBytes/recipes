package com.cmbytes.compose.recipe.presentation.viewmodels.navigation

import com.cmbytes.compose.recipe.presentation.viewmodels.navigation.models.Section

interface SectionNavigationViewModel {

    val section: Section

    fun navigateTo(section: Section)
}