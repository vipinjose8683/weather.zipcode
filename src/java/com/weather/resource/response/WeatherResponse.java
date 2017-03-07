package com.weather.resource.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    
    private CurrentWeather[] weather;
    
    private Main main;
    
    private Wind wind;
    
    private String name;

    public CurrentWeather[] getWeather() {
        return weather;
    }

    public void setWeather(CurrentWeather[] weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
