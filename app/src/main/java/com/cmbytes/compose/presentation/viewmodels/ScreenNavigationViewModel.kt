package com.cmbytes.compose.presentation.viewmodels

import com.cmbytes.compose.presentation.navigation.Screen

interface ScreenNavigationViewModel {
    val currentScreen: Screen

    fun navigateTo(screen: Screen)
    fun onBack()
}