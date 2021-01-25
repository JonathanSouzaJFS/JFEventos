package br.jfeventos.home.di

import br.jfeventos.home.ui.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeFeaturesModule = module {
    viewModel { HomeViewModel(get()) }
}