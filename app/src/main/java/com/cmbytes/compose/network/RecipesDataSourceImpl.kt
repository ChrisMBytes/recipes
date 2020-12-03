package com.cmbytes.compose.network

import com.cmbytes.compose.network.models.RecipesNet
import com.cmbytes.compose.network.api.RecipesApi
import com.cmbytes.compose.domain.resulttypes.ResultType
import com.cmbytes.compose.network.extensions.safeApiCall

class RecipesDataSourceImpl(
    private val recipesApi: RecipesApi
): RecipesDataSource {

    override suspend fun getRecipes(): ResultType<RecipesNet> =
        safeApiCall {
            recipesApi.getRecipes()
        }
}