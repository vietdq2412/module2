package view;


import controller.WeatherController;
import model.Weather;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class WeatherView {
    WeatherController weatherController = WeatherController.getInstance();
    Scanner scanner = new Scanner(System.in);
    private static final WeatherView instance = new WeatherView();

    private WeatherView() {
    }

    public static WeatherView getInstance() {
        return instance;
    }

    public void showWeatherMenu() {
        System.out.println("========= Weather ==========");
        System.out.println("============================");
        System.out.println("Enter province: ");
        String province = scanner.nextLine();
        if (province.isEmpty()) {
            System.out.println("pls enter province!");
            showWeatherMenu();
        }
        weatherController.showAllWeather(province.replace(' ', '-'));
    }

    public void showAllWeather(List<Weather> list, String province) {
        for (Weather weather : list) {
            System.out.println(weather.toString());
        }

        System.out.println("===== " + province.replace('-', ' ') + "=====");
        System.out.println("|1. Back to main menu");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            MainMenu.getInstance().mainMenu();
        }
    }
}
