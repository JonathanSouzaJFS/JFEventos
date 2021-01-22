package br.com.jfeventos.utils

sealed class NetworkResponse<out data : Any> {
    data class Success<out T : Any>(val data: T) : NetworkResponse<T>()
    data class NetworkError(val exception: String) : NetworkResponse<Nothing>()
    data class Error(val exception: String) : NetworkResponse<Nothing>()
}