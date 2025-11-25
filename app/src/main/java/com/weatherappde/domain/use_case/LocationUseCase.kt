package com.weatherappde.domain.use_case

import android.location.Location

interface LocationUseCase {
    suspend operator fun invoke(): Location?
}