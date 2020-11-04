package com.cmbytes.compose.repository.mappers

import com.cmbytes.compose.api.ExtendedIngredientNet
import com.cmbytes.compose.domain.models.ExtendedIngredient
import javax.inject.Inject

class ExtendedIngredientMapper @Inject constructor(
    private val measuresMapper: MeasuresMapper
) {

    fun to(extendedIngredient: ExtendedIngredientNet): ExtendedIngredient =
        with(extendedIngredient) {
            ExtendedIngredient(
                aisle ?: "",
                amount,
                consistency ?: "",
                id ?: 0,
                image ?: "",
                measuresMapper.to(measures),
                meta,
                metaInformation,
                name,
                original,
                originalName,
                originalString,
                unit
            )
        }
}