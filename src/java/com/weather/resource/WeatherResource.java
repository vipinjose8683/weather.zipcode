package com.weather.resource;

import java.text.MessageFormat;

import org.springframework.web.client.RestTemplate;

import com.weather.resource.response.WeatherResponse;

public class WeatherResource {

    private String urlTemplate = "http://api.openweathermap.org/data/2.5/weather?zip={0},us&appId=15b036135ee40e8aa0eb8a40ceec15e0";

    private MessageFormat formatter = new MessageFormat(urlTemplate);

    private RestTemplate restTemplate = new RestTemplate();

    public WeatherResponse findByZipCode(String zipCode) {
        WeatherResponse response = null;
        try {
            String url = formatter.format(new String[] {zipCode});
            response =  restTemplate.getForObject(url, WeatherResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
    
}
