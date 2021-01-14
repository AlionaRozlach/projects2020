package space.rozlach.myweather;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import space.rozlach.myweather.FiveDaysWeather.City;
import space.rozlach.myweather.Retrofit.ApiClient;
import space.rozlach.myweather.Retrofit.ApiInterface;
import space.rozlach.myweather.adapter.ForecastRVAdapter;

import space.rozlach.myweather.FiveDaysWeather.ForecastWeatherResponse;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastWeatherActivity extends AppCompatActivity {

    private RecyclerView weatherListRV;
    private TextView cityFTV;
    private ForecastRVAdapter adapter;
    private String forecast_weather_url;
    private City city;
    private String value;
    private   ForecastWeatherResponse forecastWeatherResponse;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_forecast_weather);

        Bundle extras = getIntent().getExtras();
        weatherListRV= findViewById(R.id.weatherListRV);

        fragment = new Fragment();
        if (extras != null) {
            value = extras.getString("city");
            String k = Locale.getDefault().getDisplayLanguage();
            getWeatherFiveDayData(value,fragment, weatherListRV, k);


        }else {

        }



    }

    private void getWeatherFiveDayData(String name,Fragment fr, RecyclerView rv, String k) {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        System.out.println("88888888888888888888888888888k***************************" + k);

        if(k.equals("русский"))
        {
            k = "ru";
            System.out.println("***************************************************" + k);
        }

        Call<ForecastWeatherResponse> call = apiInterface.getWeatherFiveDayData(name, k);







        call.enqueue(new Callback<ForecastWeatherResponse>() {

            @Override
            public void onResponse(Call<ForecastWeatherResponse> call, Response<ForecastWeatherResponse> response) {
                if (response.isSuccessful()){

                    ForecastWeatherResponse forecastWeatherResponse = new ForecastWeatherResponse();
                    forecastWeatherResponse = response.body();
                    List<space.rozlach.myweather.FiveDaysWeather.List> weatherLists = forecastWeatherResponse.getList();

                    if(weatherLists!=null){
                    if (adapter == null){
                        adapter = new ForecastRVAdapter(weatherLists,fr.getContext());
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(fr.getContext());
                        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                        rv.setLayoutManager(linearLayoutManager);
                        rv.setAdapter(adapter);
                    } else {
                        adapter.updateCollection(weatherLists);

                    }}

                }
                else{
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Please check the input is correct", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ForecastWeatherActivity.this, SearchActivity.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onFailure(Call<ForecastWeatherResponse> call, Throwable t) {
                Context context = getApplicationContext();
                Toast.makeText(context, "Please check the input is correct", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ForecastWeatherActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}