package com.weatherappde.data.remote.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.weatherappde.data.remote.dto.WeatherDto
import com.weatherappde.domain.model.WeatherInfoDomain
import com.weatherappde.utils.baseMapper.BaseMapper
import java.time.LocalDateTime

class WeatherDtoToWeatherInfoDomainMapper(
    private val weatherDataDtoToWeatherDataDomainMapper: WeatherDataDtoToWeatherDataDomainMapper
) : BaseMapper<WeatherDto, WeatherInfoDomain> {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun mapModel(model: WeatherDto): WeatherInfoDomain {
        return with(model) {
            val weatherDataMap =
                weatherDataDtoToWeatherDataDomainMapper.mapModelGrouped(weatherData)
            val now = LocalDateTime.now()
            val currentWeatherData = weatherDataMap[0]?.find {
                val hour = when {
                    now.minute < 30 -> now.hour
                    now.hour == 23 -> 12
                    else -> now.hour + 1
                }
                it.time.hour == hour
            }
            WeatherInfoDomain(
                weatherDataPerDay = weatherDataMap,
                currentWeatherDataDomain = currentWeatherData
            )
        }
    }
}