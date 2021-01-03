package com.cmbytes.compose.recipes.presentation.store

import com.cmbytes.compose.recipes.domain.models.Recipe
import com.cmbytes.compose.recipes.presentation.store.RecipesAction.*
import com.cmbytes.compose.testing.general.BaseTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class RecipesReducerTest : BaseTest() {

    private val mockRecipe = mockk<Recipe>()

    private val sut = RecipesReducer()

    @Test
    fun `update() - with action Update updates the state`() {
        val mockRecipes = listOf(mockRecipe)
        val updateAction = Update(mockRecipes)

        sut.update(updateAction)

        assertThat(sut.state.value.recipes).isEqualTo(mockRecipes)
    }
}