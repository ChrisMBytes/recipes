package com.cmbytes.compose.recipe.presentation.proxy

import com.cmbytes.compose.presentation.store.Reducer
import com.cmbytes.compose.recipe.presentation.store.RecipeAction
import com.cmbytes.compose.recipe.presentation.store.RecipeAction.Load
import com.cmbytes.compose.recipe.presentation.store.RecipeAction.Update
import com.cmbytes.compose.recipe.presentation.store.RecipeState
import com.cmbytes.compose.recipes.presentation.store.RecipesAction
import com.cmbytes.compose.recipes.presentation.store.RecipesState
import kotlinx.coroutines.flow.StateFlow

class RecipesProxyImpl(
    private val recipesReducer: Reducer<RecipesAction, RecipesState>,
    private val recipeReducer: Reducer<RecipeAction, RecipeState>
) : RecipesProxy {

    override val state: StateFlow<RecipeState>
        get() = recipeReducer.state

    override suspend fun dispatch(recipeAction: RecipeAction) {
        when (recipeAction) {
            is Load -> {
                recipesReducer.state.value.recipes.find { it.id == recipeAction.recipeId }?.run {
                    recipeReducer.update(Update(this))
                }
            }
        }
    }
}