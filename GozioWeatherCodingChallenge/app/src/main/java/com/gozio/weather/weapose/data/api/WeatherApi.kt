package com.gozio.weather.weapose.data.api

import android.provider.UserDictionary.Words.APP_ID
import com.gozio.weather.weapose.data.model.CurrentWeather
import com.gozio.weather.weapose.presentation.utils.Constants.API_KEY
import com.gozio.weather.weapose.presentation.utils.Constants.Key.LAT
import com.gozio.weather.weapose.presentation.utils.Constants.Key.LON
import com.gozio.weather.weapose.presentation.utils.Constants.Key.UNITS
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("weather")
    suspend fun getWeather(@Query(LAT) lat: Double, @Query("lon") long: Double, @Query(APP_ID) apiKey: String = API_KEY, @Query(UNITS) unit: String = "imperial") : Response<CurrentWeather>

}