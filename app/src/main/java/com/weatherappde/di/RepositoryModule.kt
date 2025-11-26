package com.weatherappde.di

import com.weatherappde.data.remote.repository.LocationRepositoryImpl
import com.weatherappde.data.remote.repository.WeatherRepositoryImpl
import com.weatherappde.domain.repository.LocationRepository
import com.weatherappde.domain.repository.WeatherRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<WeatherRepository> {
        WeatherRepositoryImpl(
            weatherApi = get(),
            weatherDtoToWeatherInfoDomainMapper = get()
        )
    }
    single<LocationRepository> {
        LocationRepositoryImpl(locationClient = get(), application = get())
    }
}