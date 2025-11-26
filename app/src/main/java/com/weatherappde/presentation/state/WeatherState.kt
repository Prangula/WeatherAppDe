package com.weatherappde.presentation.state

import com.weatherappde.domain.model.WeatherInfoDomain

data class WeatherState(
    val weatherInfo: WeatherInfoDomain? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)