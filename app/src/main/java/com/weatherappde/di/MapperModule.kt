package com.weatherappde.di

import com.weatherappde.data.remote.mapper.WeatherDataDtoToWeatherDataDomainMapper
import com.weatherappde.data.remote.mapper.WeatherDtoToWeatherInfoDomainMapper
import org.koin.dsl.module

val mapperModule = module {
    single { WeatherDataDtoToWeatherDataDomainMapper() }
    single { WeatherDtoToWeatherInfoDomainMapper(weatherDataDtoToWeatherDataDomainMapper = get()) }
}