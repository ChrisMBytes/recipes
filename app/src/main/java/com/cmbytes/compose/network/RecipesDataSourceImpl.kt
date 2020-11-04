package com.cmbytes.compose.network

import com.cmbytes.compose.api.RecipesNet
import com.cmbytes.compose.api.RecipesApi
import com.cmbytes.compose.domain.resulttypes.ResultType
import com.cmbytes.compose.network.extensions.safeApiCall
import javax.inject.Inject

class RecipesDataSourceImpl @Inject constructor(
    private val recipesApi: RecipesApi
): RecipesDataSource {

    override suspend fun getRecipes(): ResultType<RecipesNet> =
        safeApiCall {
            recipesApi.getRecipes()
        }
}