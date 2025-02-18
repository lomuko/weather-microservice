package es.davidtor.weather.service;

import es.davidtor.weather.model.WeatherResponse;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${openweather.api.key}")
    private String apiKey;

    @Value("${openweather.api.url}")
    private String apiUrl;

    //WEATHER_API_URL = "http://api.openweathermap.org/data/2.5/weather?q={city}&appid={apikey}";
    public WeatherResponse getWeather(String city) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(apiKey);
        return restTemplate.getForObject(apiUrl, WeatherResponse.class, city, apiKey);
    }
}