package com.example.weatherapp;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class WeatherReportArrayAdapter extends ArrayAdapter<WeatherReportModel> {

    private Context mContext;
    List<WeatherReportModel> reports = new ArrayList<>();

    public WeatherReportArrayAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    //TODO finish this class

}
