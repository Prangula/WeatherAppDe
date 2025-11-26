package com.weatherappde.domain.model

data class WeatherInfoDomain(
    val weatherDataPerDay: Map<Int, List<WeatherDataDomain>>,
    val currentWeatherDataDomain: WeatherDataDomain?
)
