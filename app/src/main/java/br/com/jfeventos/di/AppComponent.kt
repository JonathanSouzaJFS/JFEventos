package br.com.jfeventos.di

import br.jfeventos.domain.di.domainModule

val appComponent = listOf(
    dataModule,
    domainModule,
    viewModelModule
)