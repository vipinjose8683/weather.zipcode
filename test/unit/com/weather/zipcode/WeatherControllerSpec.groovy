package com.weather.zipcode



import grails.test.mixin.*
import spock.lang.*

@TestFor(WeatherController)
@Mock(Weather)
class WeatherControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.weatherInstanceList
            model.weatherInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.weatherInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def weather = new Weather()
            weather.validate()
            controller.save(weather)

        then:"The create view is rendered again with the correct model"
            model.weatherInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            weather = new Weather(params)

            controller.save(weather)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/weather/show/1'
            controller.flash.message != null
            Weather.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def weather = new Weather(params)
            controller.show(weather)

        then:"A model is populated containing the domain instance"
            model.weatherInstance == weather
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def weather = new Weather(params)
            controller.edit(weather)

        then:"A model is populated containing the domain instance"
            model.weatherInstance == weather
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/weather/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def weather = new Weather()
            weather.validate()
            controller.update(weather)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.weatherInstance == weather

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            weather = new Weather(params).save(flush: true)
            controller.update(weather)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/weather/show/$weather.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/weather/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def weather = new Weather(params).save(flush: true)

        then:"It exists"
            Weather.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(weather)

        then:"The instance is deleted"
            Weather.count() == 0
            response.redirectedUrl == '/weather/index'
            flash.message != null
    }
}
