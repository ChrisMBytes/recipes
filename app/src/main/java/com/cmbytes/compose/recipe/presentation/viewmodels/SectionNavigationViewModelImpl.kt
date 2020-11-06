package com.cmbytes.compose.recipe.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.cmbytes.compose.recipe.presentation.navigation.Section

class SectionNavigationViewModelImpl : ViewModel(), SectionNavigationViewModel {

    override val section: Section
        get() = _section
    private var _section: Section by mutableStateOf(Section.Ingredients(0))

    override fun navigateTo(section: Section) {
        _section = section
    }
}