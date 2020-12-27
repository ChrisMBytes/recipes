package com.cmbytes.compose.recipes.repository.mappers

import com.cmbytes.compose.recipes.network.models.RecipesNet
import com.cmbytes.compose.recipes.domain.models.Recipes
import com.cmbytes.compose.domain.resulttypes.ResultType
import javax.inject.Inject

class RecipesMapper @Inject constructor(
    private val recipeMapper: RecipeMapper
) {

    fun to(resultTypeRecipeNet: ResultType<RecipesNet>): ResultType<Recipes> =
        when(resultTypeRecipeNet) {
            is ResultType.Success -> ResultType.Success(to(resultTypeRecipeNet.data))
            is ResultType.Error -> ResultType.Error(resultTypeRecipeNet.state)
        }

    fun to(recipesNet: RecipesNet): Recipes =
        with(recipesNet) {
            Recipes(
                recipes.map { recipeMapper.to(it) }
            )
        }
}