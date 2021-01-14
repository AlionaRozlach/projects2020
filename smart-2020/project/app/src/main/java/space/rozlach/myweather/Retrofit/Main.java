package space.rozlach.myweather.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Main {


    @SerializedName("temp")
    String temp;

    @SerializedName("humidity")
    String humidity;

    @SerializedName("feels_like")
    String feels_like;


    @SerializedName("speed")
    String speed;

//    @SerializedName("weather")
//    String weather ;
    @SerializedName("temp_min")
    String min_temp;

    @SerializedName("temp_max")
    String max_temp;

    @SerializedName("pressure")
    String pressure;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getMinTemp() {
        return min_temp;
    }

    public void setMinTemp(String min_temp) {
        this.min_temp = min_temp;
    }

    public String getMaxTemp() {
        return max_temp;
    }

    public void setMaxTemp(String max_temp) {
        this.max_temp = max_temp;
    }


    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(String feels_like) {
        this.feels_like = feels_like;
    }


    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

}
