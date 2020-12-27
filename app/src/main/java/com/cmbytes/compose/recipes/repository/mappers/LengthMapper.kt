package com.cmbytes.compose.recipes.repository.mappers

import com.cmbytes.compose.recipes.network.models.LengthNet
import com.cmbytes.compose.recipes.domain.models.Length
import javax.inject.Inject

class LengthMapper @Inject constructor() {

    fun to(length: LengthNet?): Length =
        length?.let {
            with(length) {
                Length(number, unit)
            }
        } ?: Length(0, "")
}