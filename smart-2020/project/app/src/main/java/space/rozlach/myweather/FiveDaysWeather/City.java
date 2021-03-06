
package space.rozlach.myweather.FiveDaysWeather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
//    @SerializedName("coord")
//    @Expose
//    private xyz.hasnat.weather.model.ForecastWeather.Coord coord;
    @SerializedName("country")
    @Expose
    private String country;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public xyz.hasnat.weather.model.ForecastWeather.Coord getCoord() {
//        return coord;
//    }
//
//    public void setCoord(xyz.hasnat.weather.model.ForecastWeather.Coord coord) {
//        this.coord = coord;
//    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
