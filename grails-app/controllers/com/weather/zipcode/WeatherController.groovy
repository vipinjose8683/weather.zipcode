package com.weather.zipcode

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class WeatherController {
	
	def weatherService
	
    def index(Integer max) {
        redirect action: "show", id: 1
    }

    def show(Weather weatherInstance) {
        respond weatherInstance
    }

    def search() {
		def searchZipCode = params.myField
		println searchZipCode
		if (!searchZipCode.matches("\\d{5}")) {
            invalidZipCode()
            return
		}
		def weatherInstance = Weather.findByZipCode(searchZipCode)
		if (weatherInstance == null) {
			weatherInstance = new Weather()
			weatherInstance.zipCode = searchZipCode
		}
		weatherInstance = weatherService.getUpdatedInfo(weatherInstance);
        if (weatherInstance == null) {
            notFound()
            return
        }
		println weatherInstance.name
		weatherInstance.save flush: true, failOnError: true
        redirect action: "show", id: weatherInstance.id
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'weather.zipcode.notfound', args: [params.myField])
                redirect action: "show", id: 1, method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
	
	protected void invalidZipCode() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'weather.zipcode.invalid', args: [params.myField])
                redirect action: "show", id: 1, method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

}
