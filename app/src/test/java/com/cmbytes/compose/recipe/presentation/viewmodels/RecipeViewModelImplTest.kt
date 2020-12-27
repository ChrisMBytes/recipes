package com.cmbytes.compose.recipe.presentation.viewmodels

import com.cmbytes.compose.recipes.domain.models.Recipe
import com.cmbytes.compose.presentation.proxy.RecipesProxy
import com.cmbytes.compose.recipe.presentation.store.RecipeAction.*
import com.cmbytes.compose.recipe.presentation.store.RecipeState
import com.cmbytes.compose.recipe.presentation.store.RecipeState.*
import com.cmbytes.compose.utils.ViewModelBaseTest
import io.mockk.coEvery
import io.mockk.coVerify
import kotlinx.coroutines.flow.MutableStateFlow
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class RecipeViewModelImplTest : ViewModelBaseTest() {

    private val mockRecipe = mockk<Recipe>()
    private val mockRecipesProxy = mockk<RecipesProxy>(relaxed = true)

    private lateinit var sut: RecipeViewModel

    private fun setup() {
        sut = RecipeViewModelImpl(
            mockRecipesProxy,
            mockCoroutineDispatchers
        )
    }

    @Test
    fun `init - observes RecipeState`() {
        val mockRecipeState = CurrentRecipe(mockRecipe)
        giveRecipeState(mockRecipeState)

        setup()

        coVerify(exactly = 1) { mockRecipesProxy.state }
        assertThat(sut.recipeState).isEqualTo(mockRecipeState)
    }

    @Test
    fun `load() - dispatches action load with recipe id`() {
        giveRecipeState()
        val mockRecipeId = 1
        setup()

        sut.load(mockRecipeId)

        coVerify(exactly = 1) { mockRecipesProxy.dispatch(Load(mockRecipeId)) }
    }

    // Given

    private fun giveRecipeState(recipeState: RecipeState = CurrentRecipe(mockRecipe)) {
        coEvery { mockRecipesProxy.state } returns MutableStateFlow(recipeState)
    }
}