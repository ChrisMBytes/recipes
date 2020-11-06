package com.cmbytes.compose.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.cmbytes.compose.presentation.navigation.Screen

class ScreenNavigationViewModelImpl : ViewModel(), ScreenNavigationViewModel {

    private val backStack = ArrayDeque<Screen>()

    override val currentScreen: Screen
        get() = _currentScreen
    private var _currentScreen: Screen by mutableStateOf(Screen.Home)

    init {
        backStack.addFirst(Screen.Home)
    }

    override fun navigateTo(screen: Screen) {
        _currentScreen = screen
        backStack.addFirst(screen)
    }

    override fun onBack() {
        backStack.removeFirst()
        _currentScreen = backStack.first()
    }
}