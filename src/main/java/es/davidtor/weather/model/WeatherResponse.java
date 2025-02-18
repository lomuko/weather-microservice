package es.davidtor.weather.model;

import lombok.Data;

@Data
public class WeatherResponse {
    private String name;
    private Main main;
    private Wind wind;
    private Sys sys;

    @Data
    public static class Main {
        private Double temp;
        private Integer pressure;
        private Integer humidity;
    }

    @Data
    public static class Wind {
        private Double speed;
    }

    @Data
    public static class Sys {
        private String country;
    }
}