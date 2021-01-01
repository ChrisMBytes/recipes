package com.cmbytes.compose.recipes.presentation.viewmodels.navigation

import com.cmbytes.compose.recipes.presentation.viewmodels.navigation.models.Screen

interface ScreenNavigationViewModel {
    val currentScreen: Screen

    fun navigateTo(screen: Screen)
    fun onBack()
}