package com.weatherappde.domain.use_case

import com.weatherappde.domain.model.WeatherInfoDomain
import com.weatherappde.utils.resource.Resource

interface WeatherUseCase {
    suspend operator fun invoke(lan: Double, long: Double): Resource<WeatherInfoDomain>
}