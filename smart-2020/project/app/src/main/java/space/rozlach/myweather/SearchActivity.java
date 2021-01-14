package space.rozlach.myweather;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

public class SearchActivity extends AppCompatActivity {

    ImageView search;
    String name;
    EditText textField;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        search = findViewById(R.id.search);
        textField = findViewById(R.id.textField);

        name  = textField.getText().toString();
        Context context = getApplicationContext();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                save_Text();
//                if (textField.getText().toString()==null) {
//                    Toast.makeText(context, "Please, enter your city", Toast.LENGTH_SHORT).show();
//                } else {


                    SharedPreferences sharedPref = getSharedPreferences("ll", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("m_city", textField.getText().toString());
                    editor.apply();

                   Intent intent = new Intent(SearchActivity.this, TodayForecastActivity.class);
//                intent.putExtra("city",textField.getText().toString());

                    startActivity(intent);
//                }
            }

        });

//        load_Text();
    }

//    private void save_Text() {
//        prefs = getPreferences(MODE_PRIVATE);
//        SharedPreferences.Editor ed = prefs.edit();
//        ed.putString("SavedText", textField.getText().toString());
//        ed.commit();
//
//
//    }
//
//    private void load_Text(){
//        prefs = getPreferences(MODE_PRIVATE);
//        String savedText =prefs.getString("SavedText","");
//        textField.setText(savedText);
//    }
//
//
//    @Override
//    protected void onDestroy(){
//        super.onDestroy();
//        save_Text();
//    }

}
