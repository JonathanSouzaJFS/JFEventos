package br.jfeventos.details.di

import br.jfeventos.details.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailsFeaturesModule = module {
    viewModel { DetailsViewModel(get()) }
}