package com.cmbytes.compose.domain.error

sealed class ErrorState {
    object ConnectivityError : ErrorState()
    object AuthorizationError : ErrorState()
    data class NetworkError(val errorCode: ApiErrorCode) : ErrorState()
    data class GenericError(val exception: Exception) : ErrorState()
}