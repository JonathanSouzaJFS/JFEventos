package br.com.jfeventos.utils

sealed class NetworkResponse<out data : Any> {
    data class Success<out T : Any>(val data: T) : NetworkResponse<T>()
    data class Error(val exception: String) : NetworkResponse<Nothing>()
    object Loading : NetworkResponse<Nothing>()
}