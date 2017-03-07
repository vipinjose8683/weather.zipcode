package com.weather.zipcode

class Weather {

	Integer zipCode
	Integer temperature
	String iconUrl
	Date lastUpdated 
	
    static constraints = {
		zipCode nullable: true, size: 5, unique: true
		temperature nullable: true
		iconUrl nullable: true
    }
	
}
