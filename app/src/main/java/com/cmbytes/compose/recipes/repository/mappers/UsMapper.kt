package com.cmbytes.compose.recipes.repository.mappers

import com.cmbytes.compose.recipes.network.models.UsNet
import com.cmbytes.compose.recipes.domain.models.Us
import javax.inject.Inject

class UsMapper @Inject constructor() {

    fun to(usNet: UsNet): Us =
        with(usNet) {
            Us(amount, unitLong, unitShort)
        }
}