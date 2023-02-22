package com.gozio.weather.weapose.presentation.model.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gozio.weather.weapose.data.repository.WeatherRepository
import com.gozio.weather.weapose.presentation.ui.home.CurrentWeatherViewModel

class CurrentWeatherViewModelFactory constructor(private val repository: WeatherRepository) :ViewModelProvider.Factory  {

    override fun <T: ViewModel> create(model : Class<T>) : T {
        return CurrentWeatherViewModel(this.repository) as T
    }
}