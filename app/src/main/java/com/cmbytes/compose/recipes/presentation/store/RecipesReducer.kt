package com.cmbytes.compose.recipes.presentation.store

import com.cmbytes.compose.presentation.store.Reducer
import com.cmbytes.compose.recipes.presentation.store.RecipesAction.Update
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RecipesReducer : Reducer<RecipesAction, RecipesState> {

    override val state: StateFlow<RecipesState>
        get() = _state
    private val _state = MutableStateFlow(RecipesState(emptyList()))

    override fun update(action: RecipesAction) {
        when (action) {
            is Update -> _state.value.copy(recipes = action.recipes)
        }.apply {
            _state.value = this
        }
    }
}