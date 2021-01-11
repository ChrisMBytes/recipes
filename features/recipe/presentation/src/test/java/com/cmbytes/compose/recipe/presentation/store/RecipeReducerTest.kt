package com.cmbytes.compose.recipe.presentation.store

import com.cmbytes.compose.recipe.presentation.store.RecipeAction.*
import com.cmbytes.compose.recipe.presentation.store.RecipeState.*
import com.cmbytes.compose.recipes.domain.models.Recipe
import com.cmbytes.compose.testing.general.BaseTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class RecipeReducerTest : BaseTest() {

    private val mockRecipe = mockk<Recipe>()

    private val sut = RecipeReducer()

    @Test
    fun `initial state is Loading`() {
        assertThat(sut.state.value).isEqualTo(Loading)
    }

    @Test
    fun `update() - with action Update when current state is Loading`() {
        sut.update(Update(mockRecipe))

        assertThat(sut.state.value).isEqualTo(CurrentRecipe(mockRecipe))
    }

    @Test
    fun `update() - with action Update when current state is CurrentRecipe`() {
        sut.update(Update(mockRecipe))
        val mockRecipe2 = mockk<Recipe>()

        sut.update(Update(mockRecipe2))

        assertThat(sut.state.value).isEqualTo(CurrentRecipe(mockRecipe2))
    }
}