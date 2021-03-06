package com.cmbytes.compose.recipe.presentation.viewmodels.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.cmbytes.compose.recipe.presentation.viewmodels.navigation.models.Section
import com.cmbytes.compose.recipe.presentation.viewmodels.navigation.models.Section.*

class SectionNavigationViewModelImpl : ViewModel(), SectionNavigationViewModel {

    override val section: Section
        get() = _section
    private var _section: Section by mutableStateOf(Ingredients())

    override fun navigateTo(section: Section) {
        _section = section
    }
}