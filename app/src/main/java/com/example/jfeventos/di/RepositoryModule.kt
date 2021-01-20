package com.example.jfeventos.di

import com.example.jfeventos.repository.EventRepository
import com.example.jfeventos.repository.EventRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<EventRepository> { EventRepositoryImpl(get()) }
}