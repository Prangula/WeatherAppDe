package com.weatherappde.utils.weather

import androidx.annotation.DrawableRes
import com.weatherappde.R
import com.weatherappde.utils.constants.Strings

sealed class WeatherType(
    val weatherDesc: String,
    @DrawableRes val iconRes: Int
) {
    data object ClearSky : WeatherType(
        weatherDesc = Strings.CLEAR_SKY,
        iconRes = R.drawable.ic_sunny
    )

    data object MainlyClear : WeatherType(
        weatherDesc = Strings.MAINLY_CLEAR,
        iconRes = R.drawable.ic_cloudy
    )

    data object PartlyCloudy : WeatherType(
        weatherDesc = Strings.PARTLY_CLOUDY,
        iconRes = R.drawable.ic_cloudy
    )

    data object Overcast : WeatherType(
        weatherDesc = Strings.OVERCAST,
        iconRes = R.drawable.ic_cloudy
    )

    data object Foggy : WeatherType(
        weatherDesc = Strings.FOGGY,
        iconRes = R.drawable.ic_very_cloudy
    )

    data object DepositingRimeFog : WeatherType(
        weatherDesc = Strings.DEPOSITING_RIME_FOG,
        iconRes = R.drawable.ic_very_cloudy
    )

    data object LightDrizzle : WeatherType(
        weatherDesc = Strings.LIGHT_DRIZZLE,
        iconRes = R.drawable.ic_rainshower
    )

    data object ModerateDrizzle : WeatherType(
        weatherDesc = Strings.MODERATE_DRIZZLE,
        iconRes = R.drawable.ic_rainshower
    )

    data object DenseDrizzle : WeatherType(
        weatherDesc = Strings.DENSE_DRIZZLE,
        iconRes = R.drawable.ic_rainshower
    )

    data object LightFreezingDrizzle : WeatherType(
        weatherDesc = Strings.LIGHT_FREEZING_DRIZZLE,
        iconRes = R.drawable.ic_snowyrainy
    )

    data object DenseFreezingDrizzle : WeatherType(
        weatherDesc = Strings.DENSE_FREEZING_DRIZZLE,
        iconRes = R.drawable.ic_snowyrainy
    )

    data object SlightRain : WeatherType(
        weatherDesc = Strings.SLIGHT_RAIN,
        iconRes = R.drawable.ic_rainy
    )

    data object ModerateRain : WeatherType(
        weatherDesc = Strings.MODERATE_RAIN,
        iconRes = R.drawable.ic_rainy
    )

    data object HeavyRain : WeatherType(
        weatherDesc = Strings.HEAVY_RAIN,
        iconRes = R.drawable.ic_rainy
    )

    data object HeavyFreezingRain : WeatherType(
        weatherDesc = Strings.HEAVY_FREEZING_RAIN,
        iconRes = R.drawable.ic_snowyrainy
    )

    data object SlightSnowFall : WeatherType(
        weatherDesc = Strings.SLIGHT_SNOW_FALL,
        iconRes = R.drawable.ic_snowy
    )

    data object ModerateSnowFall : WeatherType(
        weatherDesc = Strings.MODERATE_SNOW_FALL,
        iconRes = R.drawable.ic_heavysnow
    )

    data object HeavySnowFall : WeatherType(
        weatherDesc = Strings.HEAVY_SNOW_FALL,
        iconRes = R.drawable.ic_heavysnow
    )

    data object SnowGrains : WeatherType(
        weatherDesc = Strings.SNOW_GRAINS,
        iconRes = R.drawable.ic_heavysnow
    )

    data object SlightRainShowers : WeatherType(
        weatherDesc = Strings.SLIGHT_RAIN_SHOWERS,
        iconRes = R.drawable.ic_rainshower
    )

    data object ModerateRainShowers : WeatherType(
        weatherDesc = Strings.MODERATE_RAIN_SHOWERS,
        iconRes = R.drawable.ic_rainshower
    )

    data object ViolentRainShowers : WeatherType(
        weatherDesc = Strings.VIOLENT_RAIN_SHOWERS,
        iconRes = R.drawable.ic_rainshower
    )

    data object SlightSnowShowers : WeatherType(
        weatherDesc = Strings.SLIGHT_SNOW_SHOWERS,
        iconRes = R.drawable.ic_snowy
    )

    data object HeavySnowShowers : WeatherType(
        weatherDesc = Strings.HEAVY_SNOW_SHOWERS,
        iconRes = R.drawable.ic_snowy
    )

    data object ModerateThunderstorm : WeatherType(
        weatherDesc = Strings.MODERATE_THUNDERSTORM,
        iconRes = R.drawable.ic_thunder
    )

    data object SlightHailThunderstorm : WeatherType(
        weatherDesc = Strings.SLIGHT_HAIL_THUNDERSTORM,
        iconRes = R.drawable.ic_rainythunder
    )

    data object HeavyHailThunderstorm : WeatherType(
        weatherDesc = Strings.HEAVY_HAIL_THUNDERSTORM,
        iconRes = R.drawable.ic_rainythunder
    )

    companion object {
        fun fromWMO(code: Int): WeatherType {
            return when (code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlyCloudy
                3 -> Overcast
                45 -> Foggy
                48 -> DepositingRimeFog
                51 -> LightDrizzle
                53 -> ModerateDrizzle
                55 -> DenseDrizzle
                56 -> LightFreezingDrizzle
                57 -> DenseFreezingDrizzle
                61 -> SlightRain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> LightFreezingDrizzle
                67 -> HeavyFreezingRain
                71 -> SlightSnowFall
                73 -> ModerateSnowFall
                75 -> HeavySnowFall
                77 -> SnowGrains
                80 -> SlightRainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> SlightSnowShowers
                86 -> HeavySnowShowers
                95 -> ModerateThunderstorm
                96 -> SlightHailThunderstorm
                99 -> HeavyHailThunderstorm
                else -> ClearSky
            }
        }
    }
}