package com.cmbytes.compose.repository.mappers

import com.cmbytes.compose.api.MeasuresNet
import com.cmbytes.compose.domain.models.Measures
import javax.inject.Inject

class MeasuresMapper @Inject constructor(
    private val metricMapper: MetricMapper,
    private val usMapper: UsMapper
) {

    fun to(measures: MeasuresNet): Measures =
        with(measures) {
            Measures(
                metricMapper.to(metric),
                usMapper.to(us)
            )
        }
}