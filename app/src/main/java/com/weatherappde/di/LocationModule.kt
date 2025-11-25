package com.weatherappde.di

import android.app.Application
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import org.koin.dsl.module

val locationModule = module {
    single<FusedLocationProviderClient> {
        LocationServices.getFusedLocationProviderClient(get<Application>())
    }
}