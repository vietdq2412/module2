package model;

import java.io.Serializable;

public class Weather implements Serializable {
    private String date;
    private String lowTemp;
    private String highTemp;
    private String status;
    private String humidity;
    private String windSpeed;

    public Weather() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLowTemp() {
        return lowTemp;
    }

    public void setLowTemp(String lowTemp) {
        this.lowTemp = lowTemp;
    }

    public String getHighTemp() {
        return highTemp;
    }

    public void setHighTemp(String highTemp) {
        this.highTemp = highTemp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    @Override
    public String toString() {
        return "Date: " + this.date +"|Temperature: "+ this.lowTemp +
                "-"+ highTemp + "|status: "+ this.status + "|humidity: "+
                humidity+ "|Wind speed: "+ windSpeed;
    }
}
