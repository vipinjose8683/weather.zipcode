package com.weather.resource.transformer

import com.weather.resource.WeatherResource
import com.weather.resource.response.WeatherResponse
import com.weather.zipcode.Weather

class WeatherResponseTransformer {

    def populate(WeatherResponse weatherResponse, Weather weather) {
		if (weatherResponse != null) {
			weather.name = weatherResponse.name
			weather.temperature = weatherResponse.main.temp
			weather.iconUrl = "http://openweathermap.org/img/w/" + weatherResponse.weather.icon + ".png"
			weather.description = weatherResponse.weather.description
			weather.humidity = weatherResponse.main.humidity
			weather.windSpeed = weatherResponse.wind.speed
		} else {
			weather = null
		}
		return weather
    }
}
