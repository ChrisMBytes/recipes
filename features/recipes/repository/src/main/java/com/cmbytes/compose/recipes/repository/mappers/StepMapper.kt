package com.cmbytes.compose.recipes.repository.mappers

import com.cmbytes.compose.recipes.network.models.StepNet
import com.cmbytes.compose.recipes.domain.models.Step
import javax.inject.Inject

class StepMapper @Inject constructor(
    private val equipmentMapper: EquipmentMapper,
    private val ingredientMapper: IngredientMapper,
    private val lengthMapper: LengthMapper
) {

    fun to(stepNet: StepNet): Step =
        with(stepNet) {
            Step(
                equipment.map { equipmentMapper.to(it) },
                ingredients.map { ingredientMapper.to(it) },
                lengthMapper.to(length),
                number,
                step
            )
        }
}