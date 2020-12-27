package com.cmbytes.compose.recipes.domain.repositories

import com.cmbytes.compose.recipes.domain.models.Recipes
import com.cmbytes.compose.domain.resulttypes.ResultType

interface RecipesRepository {

    suspend fun getRecipes(): ResultType<Recipes>
}