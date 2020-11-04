package com.cmbytes.compose.repository.mappers

import com.cmbytes.compose.api.AnalyzedInstructionNet
import com.cmbytes.compose.domain.models.AnalyzedInstruction
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