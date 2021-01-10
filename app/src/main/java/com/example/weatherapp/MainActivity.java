package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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

        // click listeners for each button.
        //*******************************************************************btn_cityID*******************************************************************
        btn_cityID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WeatherDataService weatherDataService = new WeatherDataService(MainActivity.this);
                // Instantiate the RequestQueue.

                //this didn´t return anything
                String cityId = weatherDataService.getCityID(et_dataInput.getText().toString());
                Toast.makeText(MainActivity.this, "Return the ID of: "+ cityId, Toast.LENGTH_SHORT).show();
            }
        });

        //*******************************************************************btn_getWeatherByCityID*********************************************************
        btn_getWeatherByCityID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "You clicked btn_getWeatherByCityName",Toast.LENGTH_LONG).show();

            }
        });

        btn_getWeatherByCityName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "You clicked "+ et_dataInput.getText(),Toast.LENGTH_LONG).show();

            }
        });

    }
}