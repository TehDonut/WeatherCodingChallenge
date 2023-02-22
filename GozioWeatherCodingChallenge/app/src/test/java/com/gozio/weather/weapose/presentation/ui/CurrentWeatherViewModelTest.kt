package com.gozio.weather.weapose.presentation.ui

import android.content.Context
import com.gozio.weather.weapose.base.BaseTest
import com.gozio.weather.weapose.data.model.CurrentWeather
import com.gozio.weather.weapose.data.repository.WeatherRepository
import com.gozio.weather.weapose.presentation.model.CurrentWeatherMapper
import com.gozio.weather.weapose.presentation.ui.home.CurrentWeatherViewModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CurrentWeatherViewModelTest : BaseTest() {
    @get:Rule
    val mockkRule = MockKRule(this)

    @MockK
    lateinit var context: Context

    @MockK
    lateinit var currentWeatherMapper: CurrentWeatherMapper

    private lateinit var viewModel: CurrentWeatherViewModel

    @MockK
    lateinit var weatherRepository: WeatherRepository

    @Before
    fun setup() {
        MockKAnnotations.init()
        viewModel = CurrentWeatherViewModel(weatherRepository)
    }

    @Test
    fun `test viewModel_getWeather`() {
        every { getWeather(any(),any()) }.answers { CurrentWeather(id = 123) }
        getWeather(123.1, 123.1)
        assert(viewModel.currentWeather.value.id == 123)
    }

    fun getWeather(lat: Double, lon: Double) {
        runBlocking {
            this.launch {
                weatherRepository.getWeather(lat, lon)
            }
        }
    }

}
