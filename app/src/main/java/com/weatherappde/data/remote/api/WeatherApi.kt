package com.weatherappde.data.remote.api

import com.weatherappde.data.remote.dto.WeatherDto
import com.weatherappde.utils.constants.Strings
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET(Strings.WEATHER_ENDPOINT)
    suspend fun getWeather(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double
    ): WeatherDto
}