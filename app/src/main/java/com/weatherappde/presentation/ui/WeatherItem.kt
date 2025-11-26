package com.weatherappde.presentation.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.weatherappde.R
import com.weatherappde.presentation.state.WeatherState
import com.weatherappde.utils.constants.Strings

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherItem(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.weatherDataPerDay?.values?.toList()?.take(3)
        ?.forEachIndexed { index, dayData ->
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 32.dp
                    )
            ) {
                val dayText = when (index) {
                    0 -> stringResource(R.string.current_day)
                    1 -> stringResource(R.string.tomorrow)
                    2 -> stringResource(R.string.day_after_tomorrow)
                    else -> Strings.EMPTY_STRING
                }

                Text(
                    text = dayText,
                    fontSize = 20.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                LazyRow {
                    items(dayData) { weatherData ->
                        WeatherHourlyDisplay(
                            weatherDataDomain = weatherData,
                            modifier = Modifier
                                .height(100.dp)
                                .padding(horizontal = 16.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
}