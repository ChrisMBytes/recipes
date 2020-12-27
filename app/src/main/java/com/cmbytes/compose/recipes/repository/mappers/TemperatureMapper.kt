package com.cmbytes.compose.recipes.repository.mappers

import com.cmbytes.compose.recipes.network.models.TemperatureNet
import com.cmbytes.compose.recipes.domain.models.Temperature
import javax.inject.Inject

class TemperatureMapper @Inject constructor() {

    fun to(temperature: TemperatureNet?): Temperature =
        temperature?.let {
            with(temperature) {
                Temperature(number, unit)
            }
        } ?: Temperature(0.0, "")
}