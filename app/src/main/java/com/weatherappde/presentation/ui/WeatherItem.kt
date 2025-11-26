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

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherItem(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    // get(0) means today, 1 means tomorrow ...
    state.weatherInfo?.weatherDataPerDay?.get(1)?.let { data ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.current_day),
                fontSize = 20.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow {
                items(data) { weatherData ->
                    WeatherHourlyDisplay(
                        weatherDataDomain = weatherData,
                        modifier = Modifier
                            .height(100.dp)
                            .padding(horizontal = 16.dp),
                    )
                }
            }
        }
    }
}