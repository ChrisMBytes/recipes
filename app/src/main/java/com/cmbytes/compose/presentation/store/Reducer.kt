package com.cmbytes.compose.presentation.store

import kotlinx.coroutines.flow.StateFlow

interface Reducer<A : Action, S : UiState> {

    val state: StateFlow<S>

    fun update(action: A)
}