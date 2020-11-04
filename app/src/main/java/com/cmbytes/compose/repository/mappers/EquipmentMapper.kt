package com.cmbytes.compose.repository.mappers

import com.cmbytes.compose.api.EquipmentNet
import com.cmbytes.compose.domain.models.Equipment
import javax.inject.Inject

class EquipmentMapper @Inject constructor(
    private val temperatureMapper: TemperatureMapper
) {

    fun to(equipment: EquipmentNet): Equipment =
        with(equipment) {
            Equipment(id, image ?: "", localizedName, name, temperatureMapper.to(temperature))
        }
}