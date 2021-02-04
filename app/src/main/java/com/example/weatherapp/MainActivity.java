package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

   //all elements that the app / activity_main contains
    Button btn_cityID, btn_getWeatherByCityID, btn_getWeatherByCityName;
    EditText et_dataInput;
    ListView lv_weatherReports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assign values to each control on the layout.
        btn_cityID = findViewById(R.id.btn_getCityID);
        btn_getWeatherByCityID = findViewById(R.id.btn_getWeatherByCityID);
        btn_getWeatherByCityName = findViewById(R.id.btn_getWeatherByCityName);
        et_dataInput = findViewById(R.id.et_dataInput);
        lv_weatherReports = findViewById(R.id.lv_weatherReports);
        final WeatherDataService weatherDataService = new WeatherDataService(MainActivity.this);

        // click listeners for each button.
        //*******************************************************************btn_cityID*******************************************************************
        btn_cityID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Instantiate the RequestQueue.

                weatherDataService.getCityID(et_dataInput.getText().toString(), new WeatherDataService.VolleyResponseListener()
                {
                    @Override
                    public <String> void onError(String message) {
                        Toast.makeText(MainActivity.this, "Error btn_cityID", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public <String> void onResponse(String cityID) {
                        et_dataInput.setText((CharSequence) cityID);
                        Toast.makeText(MainActivity.this, "Return the ID of: "+ cityID, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        // in this button we want to get the weather forecast by a cityID
        //*******************************************************************btn_getWeatherByCityID*********************************************************
        btn_getWeatherByCityID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weatherDataService.getCityForecastByID(et_dataInput.getText().toString(), new WeatherDataService.VolleyResponseListener() {
                    @Override
                    public <T> void onError(T message) {
                        Toast.makeText(MainActivity.this, "Error btn_getWeatherByCityID", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public <T> void onResponse(T response) {

                        // here we use an array Adapter instead of making our own array adapter class
                        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, weatherDataService.reports);
                        lv_weatherReports.setAdapter(arrayAdapter);

                    }
                });

                    }
                });

        //*******************************************************************btn_getWeatherByCityName*********************************************************
        btn_getWeatherByCityName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weatherDataService.getWeatherByName(et_dataInput.getText().toString(), new WeatherDataService.VolleyResponseListener() {
                    @Override
                    public <T> void onError(T message) {
                        Toast.makeText(MainActivity.this, "Error btn_getWeatherByCityID", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public <T> void onResponse(T response) {

                        // here we use an array Adapter instead of making our own array adapter class
                        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, weatherDataService.reports);
                        lv_weatherReports.setAdapter(arrayAdapter);

                    }
                });

            }
        });

    }
}