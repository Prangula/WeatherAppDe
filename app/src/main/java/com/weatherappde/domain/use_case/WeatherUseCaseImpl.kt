package com.weatherappde.domain.use_case

import com.weatherappde.domain.model.WeatherInfoDomain
import com.weatherappde.domain.repository.WeatherRepository
import com.weatherappde.utils.resource.Resource

class WeatherUseCaseImpl(
    private val weatherRepository: WeatherRepository
) : WeatherUseCase {
    override suspend fun invoke(lan: Double, long: Double): Resource<WeatherInfoDomain> {
        return weatherRepository.getWeatherData(lan, long)
    }
}