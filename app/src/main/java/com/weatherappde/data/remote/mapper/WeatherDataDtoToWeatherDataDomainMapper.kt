package com.weatherappde.data.remote.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.weatherappde.data.remote.dto.WeatherDataDto
import com.weatherappde.domain.model.WeatherDataDomain
import com.weatherappde.utils.baseMapper.BaseMapper
import com.weatherappde.utils.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherDataDomain
)

class WeatherDataDtoToWeatherDataDomainMapper : BaseMapper<WeatherDataDto, WeatherDataDomain> {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun mapModelGrouped(model: WeatherDataDto): Map<Int, List<WeatherDataDomain>> {
        return with(model) {
            time.mapIndexed { index, time ->
                val temperature = temperatures[index]
                val weatherCode = weatherCodes[index]
                val windSpeed = windSpeeds[index]
                val pressure = pressures[index]
                val humidity = humidities[index]
                IndexedWeatherData(
                    index = index,
                    data = WeatherDataDomain(
                        time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                        temperature = temperature,
                        pressure = pressure,
                        windSpeed = windSpeed,
                        humidity = humidity,
                        weatherType = WeatherType.fromWMO(weatherCode)
                    )
                )
            }.groupBy { it.index / 24 }.mapValues {
                it.value.map { it.data }
            }
        }
    }
}