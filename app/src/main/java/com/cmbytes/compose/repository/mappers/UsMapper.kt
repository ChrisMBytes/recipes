package com.cmbytes.compose.repository.mappers

import com.cmbytes.compose.network.models.UsNet
import com.cmbytes.compose.domain.models.Us
import javax.inject.Inject

class UsMapper @Inject constructor() {

    fun to(usNet: UsNet): Us =
        with(usNet) {
            Us(amount, unitLong, unitShort)
        }
}