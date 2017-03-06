package com.weather.zipcode



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class WeatherController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	
    def index(Integer max) {
        redirect action: "show", id: 1
    }

    def show(Weather weatherInstance) {
        respond weatherInstance
    }

    def search() {
		println params.myField
		def weatherInstance = Weather.findByZipCode(params.myField)
		println weatherInstance
        if (weatherInstance == null) {
            notFound()
            return
        }
        redirect action: "show", id: weatherInstance.id
    }

    def create() {
        respond new Weather(params)
    }

    @Transactional
    def save(Weather weatherInstance) {
        if (weatherInstance == null) {
            notFound()
            return
        }

        if (weatherInstance.hasErrors()) {
            respond weatherInstance.errors, view:'create'
            return
        }

        weatherInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'weather.label', default: 'Weather'), weatherInstance.id])
                redirect weatherInstance
            }
            '*' { respond weatherInstance, [status: CREATED] }
        }
    }

    def edit(Weather weatherInstance) {
        respond weatherInstance
    }

    @Transactional
    def update(Weather weatherInstance) {
        if (weatherInstance == null) {
            notFound()
            return
        }

        if (weatherInstance.hasErrors()) {
            respond weatherInstance.errors, view:'edit'
            return
        }

        weatherInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Weather.label', default: 'Weather'), weatherInstance.id])
                redirect weatherInstance
            }
            '*'{ respond weatherInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Weather weatherInstance) {

        if (weatherInstance == null) {
            notFound()
            return
        }

        weatherInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Weather.label', default: 'Weather'), weatherInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'weather.label', default: 'Weather'), params.myField])
                redirect action: "show", id: 1, method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
