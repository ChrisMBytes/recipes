package com.cmbytes.compose.recipes.repository.mappers

import com.cmbytes.compose.recipes.network.models.MetricNet
import com.cmbytes.compose.recipes.domain.models.Metric
import javax.inject.Inject

class MetricMapper @Inject constructor() {

    fun to(metric: MetricNet): Metric =
        with(metric) {
            Metric(amount, unitLong, unitShort)
        }
}