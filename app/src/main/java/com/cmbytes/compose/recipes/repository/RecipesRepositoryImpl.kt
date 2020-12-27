package com.cmbytes.compose.recipes.repository

import com.cmbytes.compose.recipes.domain.models.Recipes
import com.cmbytes.compose.domain.resulttypes.ResultType
import com.cmbytes.compose.recipes.domain.repositories.RecipesRepository
import com.cmbytes.compose.recipes.network.RecipesDataSource
import com.cmbytes.compose.recipes.repository.mappers.RecipesMapper
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