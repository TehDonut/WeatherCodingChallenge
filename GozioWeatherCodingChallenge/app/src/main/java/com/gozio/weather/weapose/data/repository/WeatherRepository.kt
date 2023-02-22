package com.gozio.weather.weapose.data.repository

import com.gozio.weather.weapose.data.api.WeatherApi
import com.gozio.weather.weapose.data.model.CurrentWeather
import com.gozio.weather.weapose.presentation.utils.Constants.WEATHER_API_BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class WeatherRepository {
    private val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build()
    private val api: WeatherApi = Retrofit.Builder().baseUrl(WEATHER_API_BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(client).build().create()

    suspend fun getWeather(lat: Double, lon: Double) : Response<CurrentWeather> {
        return api.getWeather(lat, lon)
    }

}