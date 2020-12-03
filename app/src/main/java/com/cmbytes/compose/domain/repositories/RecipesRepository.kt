package com.cmbytes.compose.domain.repositories

import com.cmbytes.compose.domain.models.Recipes
import com.cmbytes.compose.domain.resulttypes.ResultType

interface RecipesRepository {

    suspend fun getRecipes(): ResultType<Recipes>
}