package com.cmbytes.compose.recipe.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cmbytes.compose.coroutines.CoroutineDispatchers
import com.cmbytes.compose.presentation.proxy.RecipesProxy
import com.cmbytes.compose.recipe.presentation.store.RecipeAction.Load
import com.cmbytes.compose.recipe.presentation.store.RecipeState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RecipeViewModelImpl @Inject constructor(
    private val recipesProxy: RecipesProxy,
    private val coroutineDispatchers: CoroutineDispatchers
) : ViewModel(), RecipeViewModel {

    override val recipeState: RecipeState
        get() = _recipeState
    private var _recipeState: RecipeState by mutableStateOf(RecipeState.Loading)

    init {
        viewModelScope.launch(coroutineDispatchers.io) {
            recipesProxy.state.collect {
                withContext(coroutineDispatchers.main) {
                    _recipeState = it
                }
            }
        }
    }

    override fun load(recipeId: Int) {
        viewModelScope.launch(coroutineDispatchers.io) {
            recipesProxy.dispatch(Load(recipeId))
        }
    }
}