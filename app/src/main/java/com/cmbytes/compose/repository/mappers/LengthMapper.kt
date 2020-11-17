package com.cmbytes.compose.repository.mappers

import com.cmbytes.compose.network.models.LengthNet
import com.cmbytes.compose.domain.models.Length
import javax.inject.Inject

class LengthMapper @Inject constructor() {

    fun to(length: LengthNet?): Length =
        length?.let {
            with(length) {
                Length(number, unit)
            }
        } ?: Length(0, "")
}