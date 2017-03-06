package com.weather.zipcode

class Weather {

	Integer zipCode
	
	Integer temperature

    static constraints = {
		zipCode nullable: true
		temperature nullable: true
    }
	
}
