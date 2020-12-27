package com.cmbytes.compose.recipes.network

import com.cmbytes.compose.recipes.network.models.RecipesNet
import com.cmbytes.compose.domain.resulttypes.ResultType

interface RecipesDataSource {

    suspend fun getRecipes(): ResultType<RecipesNet>
}