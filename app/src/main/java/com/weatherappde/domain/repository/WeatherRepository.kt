package com.weatherappde.domain.repository

import com.weatherappde.domain.model.WeatherInfoDomain
import com.weatherappde.utils.resource.Resource

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfoDomain>
}