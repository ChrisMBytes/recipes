package com.cmbytes.compose.network

import com.cmbytes.compose.network.models.RecipesNet
import com.cmbytes.compose.domain.resulttypes.ResultType

interface RecipesDataSource {

    suspend fun getRecipes(): ResultType<RecipesNet>
}