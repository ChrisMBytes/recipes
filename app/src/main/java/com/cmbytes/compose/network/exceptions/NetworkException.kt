package com.cmbytes.compose.network.exceptions

import java.io.IOException

sealed class NetworkException : IOException() {
    object AuthorizationError : NetworkException()
}