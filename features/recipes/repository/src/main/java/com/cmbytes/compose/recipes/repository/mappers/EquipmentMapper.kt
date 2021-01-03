package com.cmbytes.compose.recipes.repository.mappers

import com.cmbytes.compose.recipes.network.models.EquipmentNet
import com.cmbytes.compose.recipes.domain.models.Equipment
import javax.inject.Inject

class EquipmentMapper @Inject constructor(
    private val temperatureMapper: TemperatureMapper
) {

    fun to(equipment: EquipmentNet): Equipment =
        with(equipment) {
            Equipment(id, image ?: "", localizedName, name, temperatureMapper.to(temperature))
        }
}