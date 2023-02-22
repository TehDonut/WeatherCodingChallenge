package com.gozio.weather.weapose.presentation.utils

import com.google.android.gms.maps.model.LatLng

object Constants {
    object DateFormat {
        const val HH_mm = "HH:mm"
        const val EE_MM_dd = "EEEE, MMM dd"
    }

    object Key {
        const val LAT_LNG = "lat_lng"
        const val LAT = "lat"
        const val LON = "lon"
        const val LNG = "lng"
        const val FROM_ROUTE = "from_route"
        const val ADDRESS_NAME = "address_name"
        const val APP_ID = "appid"
        const val UNITS = "units"
    }

    object Default {
        val LAT_LNG_DEFAULT = LatLng(33.78591032377107, -84.40964058633683)
    }
    const val WEATHER_API_BASE_URL = "https://api.openweathermap.org/data/2.5/"
    const val API_KEY = "3aa158b2f14a9f493a8c725f8133d704"
}
