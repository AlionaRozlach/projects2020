package space.rozlach.myweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private String name;
    private int cnt=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchActivities();
    }
    public void switchActivities() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
                finish();
            }

        }, 1000);
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
            if(cnt>0) {
                Intent intent = new Intent(MainActivity.this, TodayForecastActivity.class);
                startActivity(intent);
                cnt++;
            }

    }

}