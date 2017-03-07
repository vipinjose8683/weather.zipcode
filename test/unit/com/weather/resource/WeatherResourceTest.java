package com.weather.resource;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.weather.resource.response.WeatherResponse;

public class WeatherResourceTest {

    @Test
    public void getWeather() {
        WeatherResource subject = new WeatherResource();
        WeatherResponse response = subject.findByZipCode("30064");
        assertNotNull(response);
    }
}
