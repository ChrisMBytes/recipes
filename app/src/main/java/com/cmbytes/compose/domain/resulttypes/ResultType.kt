package com.cmbytes.compose.domain.resulttypes

import com.cmbytes.compose.domain.error.ErrorState

sealed class ResultType<out T : Any> {

    data class Success<out T : Any>(val data: T) : ResultType<T>()
    data class Error(val state: ErrorState) : ResultType<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[state=$state]"
        }
    }
}

fun <T : Any, R : Any> ResultType<T>.map(body: (T) -> R): ResultType<R> =
    when (this) {
        is ResultType.Success -> ResultType.Success(body(data))
        is ResultType.Error -> ResultType.Error(state)
    }