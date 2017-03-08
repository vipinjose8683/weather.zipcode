package com.weather.zipcode

class Weather {

	String zipCode
	String name
	String temperature
	String iconUrl
	String description
	String humidity
	String windSpeed
	String direction
	Date lastUpdated 
	
    static constraints = {
		zipCode nullable: true, unique: true
		name nullable: true
		temperature nullable: true
		iconUrl nullable: true
		description nullable: true
		humidity nullable: true
		windSpeed nullable: true
		direction nullable: true
    }
	
}
