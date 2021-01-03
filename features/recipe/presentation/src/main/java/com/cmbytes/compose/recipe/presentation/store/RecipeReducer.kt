package com.cmbytes.compose.recipe.presentation.store

import com.cmbytes.compose.recipes.domain.models.Recipe
import com.cmbytes.compose.presentation.store.Reducer
import com.cmbytes.compose.recipe.presentation.store.RecipeAction.Update
import com.cmbytes.compose.recipe.presentation.store.RecipeState.CurrentRecipe
import com.cmbytes.compose.recipe.presentation.store.RecipeState.Loading
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RecipeReducer : Reducer<RecipeAction, RecipeState> {

    override val state: StateFlow<RecipeState>
        get() = _state
    private val _state: MutableStateFlow<RecipeState> = MutableStateFlow(Loading)

    override fun update(action: RecipeAction) {
        when (action) {
            is Update -> update(action.recipe)
            else -> Loading
        }.apply {
            _state.value = this
        }
    }

    private fun update(recipe: Recipe): RecipeState {
        return if (_state.value is CurrentRecipe) {
            with(_state.value as CurrentRecipe) {
                copy(recipe = recipe)
            }
        } else {
            CurrentRecipe(recipe = recipe)
        }
    }
}