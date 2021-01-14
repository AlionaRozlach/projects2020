package space.rozlach.myweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import space.rozlach.myweather.FiveDaysWeather.City;
import space.rozlach.myweather.Retrofit.ApiClient;
import space.rozlach.myweather.Retrofit.ApiInterface;
import space.rozlach.myweather.Retrofit.TodayWeatherResponse;
import space.rozlach.myweather.extras.TimeAndDateConverter;

public class TodayForecastActivity extends AppCompatActivity {
    TextView city, min_max;
    TextView tempText , descText , humidityText, speedText,dateText,
    pressureText, realFeel, sunrise, sunset;
    ImageView ambient_temp, plus;
    String value;
    Button FiveDayForecast;
    City my_city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_forecast);

//        Bundle extras = getIntent().getExtras();

        SharedPreferences sharedPreferences = getSharedPreferences("your_city", MODE_PRIVATE);
        String name = sharedPreferences.getString("city","");
        if (name != null) {
//            value = extras.getString("city");
            value=name;
            city=findViewById(R.id.name_city);
            city.setText(value);


        }else {
            System.out.println("***********************");
        }

        tempText = findViewById(R.id.my_temp);
        min_max = findViewById(R.id.min_max);
        dateText = findViewById(R.id.date);
        humidityText=findViewById(R.id.humidityValue);
        pressureText=findViewById(R.id.pressure);
        realFeel=findViewById(R.id.realFeel);
        speedText=findViewById(R.id.windSpeed);
        descText = findViewById(R.id.description);
        sunrise = findViewById(R.id.sunriseText);
        sunset = findViewById(R.id.sunsetText);

        FiveDayForecast = findViewById(R.id.FiveDay);


        ambient_temp=findViewById(R.id.amb_temp);
        plus = findViewById(R.id.plus);

        FiveDayForecast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TodayForecastActivity.this, ForecastWeatherActivity.class);
                intent.putExtra("city",city.getText().toString());

                startActivity(intent);
            }
        });

        ambient_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TodayForecastActivity.this, SensorActivity.class);
                intent.putExtra("city",city.getText().toString());

                startActivity(intent);
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TodayForecastActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        String k = Locale.getDefault().getDisplayLanguage();

       getWeatherData(value.trim(), k);

   }


   private void getWeatherData(String name, String k) {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

       System.out.println("88888888888888888888888888888k***************************" + k);

       if(k.equals("русский"))
       {
           k = "ru";

       }

        Call<TodayWeatherResponse> call = apiInterface.getWeatherData(name,k);
       System.out.println("***************************************************" + k);
        call.enqueue(new Callback<TodayWeatherResponse>() {

            @Override
            public void onResponse(Call<TodayWeatherResponse> call, Response<TodayWeatherResponse> response) {

                if(response.isSuccessful()) {

                    TodayWeatherResponse ex = new TodayWeatherResponse();
                    ex = response.body();
                    descText.setText(ex.getWeather().get(0).getDescription());
                    tempText.setText(ex.getMain().getTemp() + "°C");
                    realFeel.setText(ex.getMain().getFeels_like() + "°C");
                    humidityText.setText(ex.getMain().getHumidity() + "%");
                    pressureText.setText(ex.getMain().getPressure() + "hPa");
                    speedText.setText(ex.getWind().getSpeed() + "km/h");
                    sunrise.setText(TimeAndDateConverter.getTime(ex.getSys().getSunrise()));
                    sunset.setText(TimeAndDateConverter.getTime(ex.getSys().getSunset()));


                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String formatted_date = sdf.format(calendar.getTime());


                    dateText.setText(formatted_date);

                    min_max.setText(ex.getMain().getMinTemp() + "/" + response.body().getMain().getMaxTemp());
                }
                else{
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Please check the input is correct", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(TodayForecastActivity.this, SearchActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<TodayWeatherResponse> call, Throwable t) {
                Context context = getApplicationContext();
                Toast.makeText(context, "Please check the input is correct", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TodayForecastActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }
}