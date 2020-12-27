package com.cmbytes.compose.recipes.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cmbytes.compose.coroutines.CoroutineDispatchers
import com.cmbytes.compose.recipes.domain.models.Recipe
import com.cmbytes.compose.domain.resulttypes.ResultType
import com.cmbytes.compose.recipes.domain.usecases.GetRecipes
import com.cmbytes.compose.presentation.store.Reducer
import com.cmbytes.compose.recipes.presentation.store.RecipesAction
import com.cmbytes.compose.recipes.presentation.store.RecipesAction.*
import com.cmbytes.compose.recipes.presentation.store.RecipesState
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RecipesViewModelImpl(
    recipesReducer: Reducer<RecipesAction, RecipesState>,
    getRecipes: GetRecipes,
    coroutineDispatchers: CoroutineDispatchers
) : ViewModel(), RecipesViewModel {

    override val recipes get() = _recipes
    private var _recipes by mutableStateOf(listOf<Recipe>())

    init {
        viewModelScope.launch(coroutineDispatchers.io) {
            when (val result = getRecipes()) {
                is ResultType.Success -> {
                   result.data.recipes.also {
                        recipesReducer.update(Update(it))
                    }
                }
                else -> emptyList()
            }.also {
                withContext(coroutineDispatchers.main) {
                    _recipes = it
                }
            }
        }
    }
}