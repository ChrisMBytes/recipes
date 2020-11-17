package com.cmbytes.compose.repository.mappers

import com.cmbytes.compose.network.models.IngredientNet
import com.cmbytes.compose.domain.models.Ingredient
import javax.inject.Inject

class IngredientMapper @Inject constructor() {

    fun to(ingredient: IngredientNet): Ingredient =
        with(ingredient) {
            Ingredient(id, image ?: "", localizedName, name)
        }
}