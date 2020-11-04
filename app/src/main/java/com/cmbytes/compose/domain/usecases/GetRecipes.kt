package com.cmbytes.compose.domain.usecases

import javax.inject.Inject

class GetRecipes @Inject constructor(
    private val recipesRepository: RecipesRepository
) {

    suspend operator fun invoke() = recipesRepository.getRecipes()
}