package space.rozlach.myweather.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import space.rozlach.myweather.FiveDaysWeather.ForecastWeatherResponse;

public interface ApiInterface {





    @GET("weather?appid=92756c24107bc39dd0a7541f66ba55c5&units=metric")
    Call<TodayWeatherResponse> getWeatherData(@Query("q") String name, @Query("lang") String m);

    @GET("forecast?appid=92756c24107bc39dd0a7541f66ba55c5&units=metric&cnt=15")
    Call<ForecastWeatherResponse> getWeatherFiveDayData(@Query("q") String name, @Query("lang") String k);

}
