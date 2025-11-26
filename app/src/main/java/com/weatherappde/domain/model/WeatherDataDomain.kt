package com.weatherappde.domain.model

import com.weatherappde.utils.weather.WeatherType
import java.time.LocalDateTime

data class WeatherDataDomain(
    val time: LocalDateTime,
    val temperature: Double,
    val pressure: Double,
    val windSpeed: Double,
    val humidity: Double,
    val weatherType: WeatherType
)
