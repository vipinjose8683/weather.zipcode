package com.weather.resource.transformer

import com.weather.resource.WeatherResource
import com.weather.resource.response.WeatherResponse
import com.weather.zipcode.Weather

class WeatherResponseTransformer {

	def dir = ["N","NNE","NE","ENE","E","ESE", "SE", "SSE","S","SSW","SW","WSW","W","WNW","NW","NNW"]

    def populate(WeatherResponse weatherResponse, Weather weather) {
		if (weatherResponse != null) {
			weather.name = weatherResponse.name
			weather.temperature = new BigDecimal(weatherResponse.main.temp) - new BigDecimal("272.15")
			weather.iconUrl = "http://openweathermap.org/img/w/" + weatherResponse.weather[0].icon + ".png"
			weather.description = weatherResponse.weather[0].description
			weather.humidity = weatherResponse.main.humidity
			weather.windSpeed = weatherResponse.wind.speed
			int val= (int) (weatherResponse.wind.deg/22.5) + 0.5
			weather.direction = dir[(val % 16)] 
		} else {
			weather = null
		}
		return weather
    }
}
