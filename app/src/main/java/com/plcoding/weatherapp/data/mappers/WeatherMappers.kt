package com.plcoding.weatherapp.data.mappers

import com.plcoding.weatherapp.data.remote.WeatherDataDto
import com.plcoding.weatherapp.data.remote.WeatherDto
import com.plcoding.weatherapp.domain.weather.WeatherData
import com.plcoding.weatherapp.domain.weather.WeatherInfo
import com.plcoding.weatherapp.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedWeatherData(
    val  index : Int,
    val data : WeatherData

)

fun WeatherDataDto.toWeatherDataMap(): Map<Int, List<WeatherData>> {
    return time.mapIndexed{index, time ->
    val temerature = temperatures[index]
    val weatherCode = weathercodes[index]
    val windspeed =    windspeed10m[index]
        val pressure = pressureMsl[index]
        val humidity = relativehumidity2m[index]
IndexedWeatherData(

    index = index,
data = WeatherData(
    time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
    tempretureCelsius = temerature,
    pressure = pressure,
    windSpeed = windspeed,
    humidity = humidity,
    weatherType = WeatherType.fromWMO(weatherCode)
)
)

    }.groupBy{
       it.index/24
    }.mapValues { it.value.map { it.data }}
}
fun  WeatherDto.toWeatherInfo():WeatherInfo{

    val weatherDataMap = weatherData.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {

        val hour = if (now.minute<30)now.hour else now.hour + 1
        it.time.hour == hour

    }
return  WeatherInfo(


    weatherDataPerDay= weatherDataMap,
    currentWeatherData =currentWeatherData

)
}