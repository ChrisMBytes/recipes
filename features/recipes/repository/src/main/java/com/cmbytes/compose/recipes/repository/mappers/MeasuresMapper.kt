package com.cmbytes.compose.recipes.repository.mappers

import com.cmbytes.compose.recipes.network.models.MeasuresNet
import com.cmbytes.compose.recipes.domain.models.Measures
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