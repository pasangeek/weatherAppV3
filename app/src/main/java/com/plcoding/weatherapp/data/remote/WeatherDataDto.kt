package com.plcoding.weatherapp.data.remote

import com.squareup.moshi.Json

data class WeatherDataDto(


    val time: List<String>,
    @field:Json(name = "temperature_2m")
    val temperatures: List<Double>,
    @field:Json(name = "weathercode")
    val weathercodes: List<Int>,
    @field:Json(name ="relativehumidity_2m")
    val relativehumidity2m: List<Double>,
    @field:Json(name ="windspeed_10m")
    val windspeed10m: List<Double>,
    @field:Json(name ="pressure_msl")
    val pressureMsl: List<Double>






)
