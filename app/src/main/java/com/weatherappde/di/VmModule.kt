package com.weatherappde.di

import com.weatherappde.presentation.vm.WeatherVm
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val vmModule = module {
    viewModel { WeatherVm(weatherUseCase = get(), locationUseCase = get()) }
}