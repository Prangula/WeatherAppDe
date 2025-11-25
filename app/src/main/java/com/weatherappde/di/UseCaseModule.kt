package com.weatherappde.di

import com.weatherappde.domain.use_case.LocationUseCase
import com.weatherappde.domain.use_case.LocationUseCaseImpl
import com.weatherappde.domain.use_case.WeatherUseCase
import com.weatherappde.domain.use_case.WeatherUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<WeatherUseCase> { WeatherUseCaseImpl(weatherRepository = get()) }
    single<LocationUseCase> { LocationUseCaseImpl(locationRepository = get()) }
}