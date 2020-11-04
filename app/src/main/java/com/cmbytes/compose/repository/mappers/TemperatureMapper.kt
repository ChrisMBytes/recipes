package com.cmbytes.compose.repository.mappers

import com.cmbytes.compose.api.TemperatureNet
import com.cmbytes.compose.domain.models.Temperature
import javax.inject.Inject

class TemperatureMapper @Inject constructor() {

    fun to(temperature: TemperatureNet?): Temperature =
        temperature?.let {
            with(temperature) {
                Temperature(number, unit)
            }
        } ?: Temperature(0.0, "")
}