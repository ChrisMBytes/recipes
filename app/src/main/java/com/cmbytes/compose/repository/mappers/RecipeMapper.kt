package com.cmbytes.compose.repository.mappers

import com.cmbytes.compose.network.models.RecipeNet
import com.cmbytes.compose.domain.models.Recipe
import javax.inject.Inject

class RecipeMapper @Inject constructor(
    private val analyzedInstructionMapper: AnalyzedInstructionMapper,
    private val extendedIngredientMapper: ExtendedIngredientMapper
) {

    fun to(recipe: RecipeNet): Recipe =
        with(recipe) {
            Recipe(
                aggregateLikes,
                analyzedInstructions.map { analyzedInstructionMapper.to(it) },
                author ?: "",
                cheap,
                creditsText ?: "",
                cuisines,
                dairyFree,
                diets,
                dishTypes,
                extendedIngredients.map { extendedIngredientMapper.to(it) },
                gaps,
                glutenFree,
                healthScore,
                id,
                image ?: "",
                imageType ?: "",
                instructions,
                license ?: "",
                lowFodmap,
                occasions,
                originalId ?: 0,
                pricePerServing,
                readyInMinutes,
                servings,
                sourceName ?: "",
                sourceUrl,
                spoonacularScore,
                spoonacularSourceUrl,
                summary,
                sustainable,
                title,
                vegan,
                vegetarian,
                veryHealthy,
                veryPopular,
                weightWatcherSmartPoints
            )
        }
}