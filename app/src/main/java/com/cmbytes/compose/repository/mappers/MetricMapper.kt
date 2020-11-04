package com.cmbytes.compose.repository.mappers

import com.cmbytes.compose.api.MetricNet
import com.cmbytes.compose.domain.models.Metric
import javax.inject.Inject

class MetricMapper @Inject constructor() {

    fun to(metric: MetricNet): Metric =
        with(metric) {
            Metric(amount, unitLong, unitShort)
        }
}