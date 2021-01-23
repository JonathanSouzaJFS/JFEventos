package br.jfeventos.domain.di


import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import br.jfeventos.domain.repository.UserRepository
import br.jfeventos.domain.usecase.UserRepositoryImpl
import org.koin.dsl.module

val domainModule = module {
    single<UserRepository> { UserRepositoryImpl(get()) }
    single<SharedPreferences> { PreferenceManager.getDefaultSharedPreferences(get()) }
}