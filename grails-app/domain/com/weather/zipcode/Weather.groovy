package com.weather.zipcode

class Weather {

	String zipCode
	String temperature
	String iconUrl
	String description
	String humidity
	String windSpeed
	Date lastUpdated 
	
    static constraints = {
		zipCode nullable: true, unique: true
		temperature nullable: true
		iconUrl nullable: true
		description nullable: true
		humidity nullable: true
		windSpeed nullable: true
    }
	
}
