package com.weatherappde.data.remote.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.weatherappde.data.remote.api.WeatherApi
import com.weatherappde.data.remote.mapper.WeatherDtoToWeatherInfoDomainMapper
import com.weatherappde.domain.model.WeatherInfoDomain
import com.weatherappde.domain.repository.WeatherRepository
import com.weatherappde.utils.constants.Strings
import com.weatherappde.utils.resource.Resource

class WeatherRepositoryImpl(
    private val weatherApi: WeatherApi,
    private val weatherDtoToWeatherInfoDomainMapper: WeatherDtoToWeatherInfoDomainMapper
) : WeatherRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfoDomain> {
        return try {
            Resource.Success(
                data = weatherDtoToWeatherInfoDomainMapper.mapModel(
                    weatherApi.getWeather(lat, long)
                )
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: Strings.UNKNOWN_ERROR)
        }
    }
}