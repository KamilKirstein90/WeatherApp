package com.example.weatherapp;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataService {

    public static final String QUERY_FOR_CITY_ID = "https://www.metaweather.com/api/location/search/?query=";

     private Context context;
     String cityID;

    public WeatherDataService(Context context) {
        this.context = context;
    }

    public  String getCityID(String cityName){
        // we created a constant from the query string with right click refactor and "Introduce constant..."
        String url =QUERY_FOR_CITY_ID + cityName;

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                // we get an JSONArray but want just one object from it so we create a JSONobject first

                try {

                    JSONObject cityInfo = response.getJSONObject(0);
                    cityID = cityInfo.getString("woeid");

                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
                // this worked but it didn´t return the id to the main activity
                Toast.makeText(context, cityID, Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(context, "Something Wrong", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueueSingleton.getInstance(context).addToRequestQueue(request);

        // return a NULL an asynchronous issue because of a background process
        // we use this with the volley library to not stop or disturb the UI Thread
        // Solution : Callback
        //A callback is a way to schedule a method call to occur when another method finishes its task
        // if we go "to deep" that can occur in a "Callback Hell" and get messy
        // Callbacks can be done with "async" and "await" commands in other languages.

        return cityID;
    }

    /*
    public List<WeatherReportModel> getCityForecastByID(String cityID){

    }

    public List<WeatherReportModel> getCityForecastByName (Strng cityName){

    }

    */
}
