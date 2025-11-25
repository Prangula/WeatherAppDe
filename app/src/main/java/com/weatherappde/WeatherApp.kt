package com.weatherappde

import android.app.Application
import com.weatherappde.di.locationModule
import com.weatherappde.di.mapperModule
import com.weatherappde.di.repositoryModule
import com.weatherappde.di.retrofitModule
import com.weatherappde.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@WeatherApp)
            modules(
                listOf(
                    mapperModule,
                    repositoryModule,
                    useCaseModule,
                    locationModule,
                    retrofitModule
                )
            )
        }
    }
}