package br.com.jfeventos.di

import br.com.jfeventos.repository.EventRepository
import br.com.jfeventos.repository.EventRepositoryImpl
import br.com.jfeventos.repository.UserRepository
import br.com.jfeventos.repository.UserRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<EventRepository> { EventRepositoryImpl(get()) }
    single<UserRepository> { UserRepositoryImpl(get()) }
}