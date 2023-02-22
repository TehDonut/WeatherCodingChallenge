package com.gozio.weather.weapose.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModelProvider
import com.gozio.weather.weapose.data.repository.WeatherRepository
import com.gozio.weather.weapose.presentation.model.factory.CurrentWeatherViewModelFactory
import com.gozio.weather.weapose.presentation.theme.WeaposeTheme
import com.gozio.weather.weapose.presentation.ui.home.CurrentWeatherViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        val viewModel = ViewModelProvider(this, CurrentWeatherViewModelFactory(WeatherRepository())).get(
            CurrentWeatherViewModel::class.java)


        setContent {
            WeaposeTheme {
                WeatherApp(viewModel = viewModel)
            }
        }
    }
}
