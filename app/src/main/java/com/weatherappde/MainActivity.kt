package com.weatherappde

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.weatherappde.presentation.ui.WeatherScreen
import com.weatherappde.presentation.ui.theme.WeatherAppDeTheme
import com.weatherappde.presentation.vm.WeatherVm
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vm: WeatherVm = getViewModel()
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {}
        permissionLauncher.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
            )
        )
        val splashScreen = installSplashScreen()
        enableEdgeToEdge()
        setContent {
            WeatherAppDeTheme {
                splashScreen.setKeepOnScreenCondition { false }
                WeatherScreen(state = vm.state)
            }
        }
    }
}
