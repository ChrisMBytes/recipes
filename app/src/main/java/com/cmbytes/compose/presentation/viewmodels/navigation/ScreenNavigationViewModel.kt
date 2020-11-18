package com.cmbytes.compose.presentation.viewmodels.navigation

import com.cmbytes.compose.presentation.viewmodels.navigation.models.Screen

interface ScreenNavigationViewModel {
    val currentScreen: Screen

    fun navigateTo(screen: Screen)
    fun onBack()
}