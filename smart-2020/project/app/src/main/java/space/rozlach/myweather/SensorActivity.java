package space.rozlach.myweather;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SensorActivity extends AppCompatActivity implements SensorEventListener {
    private TextView ambient_temperature;
    private Sensor sensor;
    private SensorManager sensorManager;
    private Boolean isTempSensorAvailable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambient_temperature);

        ambient_temperature = findViewById(R.id.amb_temp);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null)
        {
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
            isTempSensorAvailable = true;
        }
        else{
            ambient_temperature.setText(getString(R.string.sensor));
            isTempSensorAvailable=false;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        ambient_temperature.setText(event.values[0] + "C");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume(){
        super.onResume();
        if(isTempSensorAvailable)
        {
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        if(isTempSensorAvailable)
        {
            sensorManager.unregisterListener(this);
        }
    }
}
