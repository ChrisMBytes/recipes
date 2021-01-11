package com.cmbytes.compose.recipe.presentation.viewmodels.navigation

import com.cmbytes.compose.recipe.presentation.viewmodels.navigation.models.Section.*
import com.cmbytes.compose.testing.general.BaseTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SectionNavigationViewModelImplTest : BaseTest() {

    private val sut = SectionNavigationViewModelImpl()

    @Test
    fun `initial state is Ingredients`() {
        assertThat(sut.section).isEqualTo(Ingredients(0))
    }

    @Test
    fun `navigateTo()`() {
        sut.navigateTo(HowToCook(1))

        assertThat(sut.section).isEqualTo(HowToCook(1))
    }
}