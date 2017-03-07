package com.weather.zipcode

import grails.transaction.Transactional
import com.weather.resource.WeatherResource
import com.weather.resource.response.WeatherResponse
import com.weather.resource.transformer.WeatherResponseTransformer

@Transactional
class WeatherService {

	def weatherResource = new WeatherResource()
	
	def weatherResponseTransformer = new WeatherResponseTransformer()

    def getUpdatedInfo(Weather weatherInstance) {
		if (weatherInstance != null) {
			WeatherResponse response = weatherResource.findByZipCode(weatherInstance.zipCode)
			println response.name
			weatherInstance = weatherResponseTransformer.populate(response, weatherInstance)
			println weatherInstance.iconUrl
		}
		println "in weather service"
		return weatherInstance
    }
}
