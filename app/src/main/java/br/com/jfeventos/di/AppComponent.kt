package br.com.jfeventos.di

import br.jfeventos.details.di.detailsFeaturesModule
import br.jfeventos.domain.di.domainModule
import br.jfeventos.home.di.homeFeaturesModule

val appComponent = listOf(
    dataModule,
    domainModule,
    homeFeaturesModule,
    detailsFeaturesModule
)