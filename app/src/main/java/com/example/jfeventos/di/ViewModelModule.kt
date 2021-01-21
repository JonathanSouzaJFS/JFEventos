package com.example.jfeventos.di

import com.example.jfeventos.ui.details.DetailsViewModel
import com.example.jfeventos.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailsViewModel(get()) }
}