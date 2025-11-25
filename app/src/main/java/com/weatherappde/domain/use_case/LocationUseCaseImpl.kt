package com.weatherappde.domain.use_case

import android.location.Location
import com.weatherappde.domain.repository.LocationRepository

class LocationUseCaseImpl(
    private val locationRepository: LocationRepository
) : LocationUseCase {
    override suspend fun invoke(): Location? {
        return locationRepository.getCurrentLocation()
    }
}