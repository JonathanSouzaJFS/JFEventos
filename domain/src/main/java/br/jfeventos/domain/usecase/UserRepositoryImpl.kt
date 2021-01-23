package br.jfeventos.domain.usecase

import android.content.SharedPreferences
import androidx.core.content.edit
import br.jfeventos.domain.repository.UserRepository

private const val KEY_NAME = "NAME"
private const val KEY_EMAIL = "EMAIL"

class UserRepositoryImpl(private val preferences: SharedPreferences) : UserRepository {

    override fun setName(name: String) = data(KEY_NAME, name)
    override fun setEmail(email: String) = data(KEY_EMAIL, email)

    override fun getName() = preferences.getString(KEY_NAME, null)
    override fun getEmail() = preferences.getString(KEY_EMAIL, null)

    private fun data(key: String, data: String) {
        preferences.edit { putString(key, data) }
    }
}