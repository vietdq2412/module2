package controller;

import model.Weather;
import service.weather.WeatherService;
import view.WeatherView;

import java.util.List;
import java.util.Scanner;

public class WeatherController {
    private static final WeatherController instance = new WeatherController();
    private WeatherController(){}
    public static WeatherController getInstance(){
        return instance;
    }

    Scanner scanner = new Scanner(System.in);
    WeatherService weatherService = new WeatherService();

    public void showAllWeather(String province){
        String url_10days = "10-ngay-toi";
        String url_5days = "5-ngay-toi";
        List<Weather> listDay = weatherService.getData(province, url_5days);
        WeatherView.getInstance().showAllWeather(listDay, province);
    }

    public void showWeatherMenu(){
        WeatherView.getInstance().showWeatherMenu();
    }
}
