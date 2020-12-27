package com.cmbytes.compose.recipes.repository.mappers

import com.cmbytes.compose.recipes.network.models.AnalyzedInstructionNet
import com.cmbytes.compose.recipes.domain.models.AnalyzedInstruction
import javax.inject.Inject

class AnalyzedInstructionMapper @Inject constructor(
    private val stepMapper: StepMapper
) {

    fun to(analyzedInstruction: AnalyzedInstructionNet): AnalyzedInstruction =
        with(analyzedInstruction) {
            AnalyzedInstruction(
                name,
                steps.map { stepMapper.to(it) }
            )
        }
}