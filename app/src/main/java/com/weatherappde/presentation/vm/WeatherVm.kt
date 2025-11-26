package com.weatherappde.presentation.vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.weatherappde.domain.use_case.LocationUseCase
import com.weatherappde.domain.use_case.WeatherUseCase
import com.weatherappde.presentation.state.WeatherState
import com.weatherappde.utils.constants.Strings
import com.weatherappde.utils.extensions.viewModelScope
import com.weatherappde.utils.resource.Resource

class WeatherVm(
    private val weatherUseCase: WeatherUseCase,
    private val locationUseCase: LocationUseCase
) : ViewModel() {

    var state by mutableStateOf(WeatherState())
        private set

    init {
        getWeatherInfo()
    }

    private fun getWeatherInfo() {
        viewModelScope {
            state = state.copy(
                isLoading = true,
                errorMessage = null
            )
            locationUseCase.invoke()?.let { location ->
                when (val result = weatherUseCase.invoke(location.latitude, location.longitude)) {
                    is Resource.Success -> {
                        state = state.copy(
                            weatherInfo = result.data,
                            isLoading = false,
                            errorMessage = null
                        )
                    }

                    is Resource.Error -> {
                        state = state.copy(
                            weatherInfo = null,
                            isLoading = false,
                            errorMessage = result.message
                        )
                    }
                }
            } ?: kotlin.run {
                state = state.copy(
                    isLoading = false,
                    errorMessage = Strings.UNKNOWN_ERROR
                )
            }
        }
    }
}