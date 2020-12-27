package com.cmbytes.compose.recipes.repository.mappers

import com.cmbytes.compose.recipes.network.models.IngredientNet
import com.cmbytes.compose.recipes.domain.models.Ingredient
import javax.inject.Inject

class IngredientMapper @Inject constructor() {

    fun to(ingredient: IngredientNet): Ingredient =
        with(ingredient) {
            Ingredient(id, image ?: "", localizedName, name)
        }
}