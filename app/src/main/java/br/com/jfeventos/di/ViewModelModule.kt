package br.com.jfeventos.di

import br.com.jfeventos.ui.details.DetailsViewModel
import br.com.jfeventos.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailsViewModel(get()) }
}