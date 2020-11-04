package com.cmbytes.compose.repository

import com.cmbytes.compose.domain.models.Recipes
import com.cmbytes.compose.domain.resulttypes.ResultType
import com.cmbytes.compose.domain.usecases.RecipesRepository
import com.cmbytes.compose.network.RecipesDataSource
import com.cmbytes.compose.repository.mappers.RecipesMapper
import javax.inject.Inject

class RecipesRepositoryImpl @Inject constructor(
    private val recipesDataSource: RecipesDataSource,
    private val recipesMapper: RecipesMapper
): RecipesRepository {

    override suspend fun getRecipes(): ResultType<Recipes> {
        return recipesDataSource.getRecipes().run {
            recipesMapper.to(this)
        }
    }
}