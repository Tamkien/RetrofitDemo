package com.kienct.retrofitdemo

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {//unused
    @GET("data/2.5/weather?")
    fun getCurrentWeatherData(@Query("lat") lat: String, @Query("lon") lon: String, @Query("appId") app_id: String): Call<WeatherResponse>
}