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

}
