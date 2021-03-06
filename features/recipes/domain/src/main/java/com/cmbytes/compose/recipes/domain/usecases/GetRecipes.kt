package com.cmbytes.compose.recipes.domain.usecases

import com.cmbytes.compose.recipes.domain.repositories.RecipesRepository

class GetRecipes(private val recipesRepository: RecipesRepository) {

    suspend operator fun invoke() = recipesRepository.getRecipes()
}