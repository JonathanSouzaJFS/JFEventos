package br.jfeventos.domain.repository

interface UserRepository {
    fun setName(name: String)
    fun setEmail(email: String)
    fun getName() : String?
    fun getEmail() : String?
}