package com.example.weatherapp;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataService {

    public static final String QUERY_FOR_CITY_ID = "https://www.metaweather.com/api/location/search/?query=";
    public static final String QUERY_WEATHER_REPORT_BY_CITY_ID = "https://www.metaweather.com/api/location/";

    private Context context;
     String cityID;

    // create the listener that is working as our callback function for the response
    // and is specific to this method right now

    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(String cityID);
    }

    public WeatherDataService(Context context) {
        this.context = context;
    }
    //************************************************************************getCityID****************************************************************
    public void getCityID(String cityName, VolleyResponseListener volleyResponseListener){
        // we created a constant from the query string with right click refactor and "Introduce constant..."
        String url =QUERY_FOR_CITY_ID + cityName;


        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response)
            {

                // we get an JSONArray but want just one object from it so we create a JSONobject first
                try
                {
                    JSONObject cityInfo = response.getJSONObject(0);
                    cityID = cityInfo.getString("woeid");

                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
                volleyResponseListener.onResponse(cityID);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyResponseListener.onError("Something Wrong");
            }
        });

        RequestQueueSingleton.getInstance(context).addToRequestQueue(request);
    }

    //************************************************************************getWeatherByID***********************************************************
    public void getCityForecastByID(String cityID){

        List<WeatherReportModel> reports = new ArrayList<>();

        String url = QUERY_WEATHER_REPORT_BY_CITY_ID + cityID;
        Log.d("LOG_URL",url);

        JsonObjectRequest  request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try
                {

                        JSONArray JSONReports = response.getJSONArray("consolidated_weather");
                        for ( int i = 0; i  < JSONReports.length(); ++i)
                        {
                            JSONObject JSONReport = JSONReports.getJSONObject(i);

                            WeatherReportModel report = new WeatherReportModel(
                                                            JSONReport.getLong("id"),
                                                            JSONReport.getString("weather_state_name"),
                                                            JSONReport.getString("weather_state_abbr"),
                                                            JSONReport.getString("wind_direction_compass"),
                                                            JSONReport.getString("created"),
                                                            JSONReport.getString("applicable_date"),
                                                            (float)JSONReport.getDouble("min_temp"),
                                                            (float) JSONReport.getDouble("max_temp"),
                                                            (float) JSONReport.getDouble("the_temp"),
                                                            (float) JSONReport.getDouble("wind_speed"),
                                                            (float) JSONReport.getDouble("wind_direction"),
                                                            (float) JSONReport.getDouble("air_pressure"),
                                                            JSONReport.getInt("humidity"),
                                                            (float) JSONReport.getDouble("visibility"),
                                                            JSONReport.getInt("predictability")
                                                            );
                            reports.add(report);
                            if ( i == 0 )
                            {
                                Log.d("Erster Eintrag: ", report.toString());
                            }

                        }
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(context, "Something Wrong", Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueueSingleton.getInstance(context).addToRequestQueue(request);
    }

}
