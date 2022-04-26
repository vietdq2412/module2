package service.weather;


import model.Weather;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Entities;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WeatherService {
    public final String WEATHER_URL = "https://thoitiet.vn/";

    Document document;

    private List<Weather> weatherList;

    public WeatherService() {
    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    private void getConnect(String province, String path) {
        String url = WEATHER_URL + province + "/" + path;
        System.out.println(url);
        try {
            document = Jsoup.parse(new URL(url).openStream(), "ISO-8859-1", WEATHER_URL + path);
            document.outputSettings().escapeMode(Entities.EscapeMode.xhtml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Weather> getData(String province, String path) {
        System.out.println("Loading . . .");
        this.getConnect(province, path);
        List<Weather> list = new ArrayList<>();
        Elements elements = document.getElementsByClass("weather-day");
        for (Element e : elements) {
            Weather weather = new Weather();
            String date = e.getElementsByClass("summary-day").first().text().toLowerCase();
            String lowTemp = e.getElementsByClass("summary-temperature-min").textNodes().get(0).text().toLowerCase();
            String highTemp = e.getElementsByClass("summary-temperature-max-value").textNodes().get(0).text().toLowerCase();
            String status = e.getElementsByClass("summary-description-detail").textNodes().get(0).text().toLowerCase();
            String humidity = e.getElementsByClass("summary-humidity").last().text().toLowerCase();
            String windSpeed = e.getElementsByClass("summary-speed").last().text().toLowerCase();

            weather.setDate(date);
            weather.setLowTemp(lowTemp);
            weather.setHighTemp(highTemp);
            weather.setStatus(status);
            weather.setHumidity(humidity);
            weather.setWindSpeed(windSpeed);

            list.add(weather);
        }
        list.remove(0);

        this.weatherList = list;
        return list;
    }

    ;


}
