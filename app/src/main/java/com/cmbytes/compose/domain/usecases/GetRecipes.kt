package com.cmbytes.compose.domain.usecases

import com.cmbytes.compose.domain.repositories.RecipesRepository

class GetRecipes(private val recipesRepository: RecipesRepository) {

    suspend operator fun invoke() = recipesRepository.getRecipes()
}