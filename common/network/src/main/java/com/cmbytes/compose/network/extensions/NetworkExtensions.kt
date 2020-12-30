package com.cmbytes.compose.network.extensions

import com.cmbytes.compose.domain.resulttypes.ResultType
import com.cmbytes.compose.domain.error.ApiErrorCode
import com.cmbytes.compose.domain.error.ErrorState
import com.cmbytes.compose.domain.error.ErrorState.*
import com.cmbytes.compose.domain.resulttypes.ResultType.*
import com.cmbytes.compose.network.exceptions.NetworkException.AuthorizationError
import org.json.JSONObject
import retrofit2.Response
import java.net.ConnectException
import java.net.HttpURLConnection.HTTP_FORBIDDEN
import java.net.SocketTimeoutException
import java.net.UnknownHostException

fun <T : Any> Response<T>.toResult(): ResultType<T> {
    if (isSuccessful) {
        val body = body()
        return if (body != null) {
            Success(body)
        } else {
            Error(GenericError(IllegalStateException("Empty body in response.")))
        }
    }
    if (code() == HTTP_FORBIDDEN) {
        return Error(ErrorState.AuthorizationError)
    }

    return Error(NetworkError(errorCode = extractErrorCode()))
}

private fun <T : Any> Response<T>.extractErrorCode(): ApiErrorCode {
    val errorBody = errorBody()
    requireNotNull(errorBody) { "The body is null for this response, so we can't extract the error code." }

    val errorBodyText = errorBody.string()
    val jsonObject = JSONObject(errorBodyText)
    val errorCode = jsonObject.getString("errorCode")

    val errorCodeExistInEnum = ApiErrorCode.values().map { it.toString() }.contains(errorCode)
    require(errorCodeExistInEnum) { "Error code : $errorCode doesn't have equivalent in ApiErrorCode enum class." }

    return ApiErrorCode.valueOf(errorCode)
}

suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): ResultType<T> {
    return try {
        call().toResult()
    } catch (exception: Exception) {
        when (exception) {
            is AuthorizationError -> Error(ErrorState.AuthorizationError)
            is ConnectException, is SocketTimeoutException, is UnknownHostException -> Error(
                ConnectivityError
            )
            else -> {
//                Timber.w(exception)
                Error(GenericError(exception))
            }
        }
    }
}