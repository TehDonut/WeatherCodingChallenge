package com.gozio.weather.weapose.presentation.ui.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gozio.weather.weapose.data.model.CurrentWeather
import com.gozio.weather.weapose.data.repository.WeatherRepository
import kotlinx.coroutines.*

class CurrentWeatherViewModel(val weatherRepository: WeatherRepository) : ViewModel() {
    val errorMessage = MutableLiveData<String>()
    val currentWeather : MutableState<CurrentWeather> = mutableStateOf(CurrentWeather())
    var job: Job? = null

    fun getWeather(lat: Double, lon: Double) {
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = weatherRepository.getWeather(lat, lon)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    currentWeather.value = response.body() ?: CurrentWeather()
                }
                else {
                    errorMessage.value = response.message()
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}