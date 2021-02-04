package com.example.weatherapp;
//the WeatherReportModel should represent the JSONObject from

// https://www.metaweather.com/api/location/(woid)

/*
consolidated_weather
id	integer		Internal identifier for the forecast
applicable_date	date		Date that the forecast or observation pertains to
weather_state_name	string		Text description of the weather state
weather_state_abbr	string		One or two letter abbreviation of the weather state
wind_speed	float	mph
wind_direction	float	degrees
wind_direction_compass	string	compass point	Compass point of the wind direction
(min|max|the)_temp	integer	centigrade
air_pressure	float	mbar
humidity	float	percentage
visibility	float	miles
predictability	integer	percentage	Our interpretation of the level to which the forecasters agree with each other - 100% being a complete consensus.



{"consolidated_weather":[
	{
	"id":5456748988071936,
	"weather_state_name":"Heavy Cloud",
	"weather_state_abbr":"hc",
	"wind_direction_compass":"WNW",
	"created":"2021-01-23T09:20:03.047160Z",
	"applicable_date":"2021-01-23",
	"min_temp":0.53,
	"max_temp":4.605,
	"the_temp":4.3149999999999995,
	"wind_speed":4.407662942360614,
	"wind_direction":297.16314906731577,
	"air_pressure":995.0,
	"humidity":74,
	"visibility":7.718362264376044,
	"predictability":71},
	{...}, ...
	]};

 */

public class WeatherReportModel {

    private long id;
    private String weather_state_name;
    private String weather_state_abbr;
    private String wind_direction_compass;
    private String created;
    private String applicable_date;
    private float  min_temp;
    private float  max_temp;
    private float  the_temp;
    private float  wind_speed;
    private float  wind_direction;
    private float  air_pressure;
    private int    humidity;
    private float  visibility;
    private int    predictability;

    public WeatherReportModel(long id,
                              String weather_state_name,
                              String weather_state_abbr,
                              String wind_direction_compass,
                              String created,
                              String applicable_date,
                              float min_temp,
                              float max_temp,
                              float the_temp,
                              float wind_speed,
                              float wind_direction,
                              float air_pressure,
                              int humidity,
                              float visibility,
                              int predictability) {
        this.id = id;
        this.weather_state_name = weather_state_name;
        this.weather_state_abbr = weather_state_abbr;
        this.wind_direction_compass = wind_direction_compass;
        this.created = created;
        this.applicable_date = applicable_date;
        this.min_temp = min_temp;
        this.max_temp = max_temp;
        this.the_temp = the_temp;
        this.wind_speed = wind_speed;
        this.wind_direction = wind_direction;
        this.air_pressure = air_pressure;
        this.humidity = humidity;
        this.visibility = visibility;
        this.predictability = predictability;
    }

    @Override
    public String toString() {
        return "Date: " + applicable_date + "\n" +
                weather_state_name +
                ", Low: " + min_temp +
                ", High: " + max_temp +
                ", Actual: " + the_temp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWeather_state_name() {
        return weather_state_name;
    }

    public void setWeather_state_name(String weather_state_name) {
        this.weather_state_name = weather_state_name;
    }

    public String getWeather_state_abbr() {
        return weather_state_abbr;
    }

    public void setWeather_state_abbr(String weather_state_abbr) {
        this.weather_state_abbr = weather_state_abbr;
    }

    public String getWind_direction_compass() {
        return wind_direction_compass;
    }

    public void setWind_direction_compass(String wind_direction_compass) {
        this.wind_direction_compass = wind_direction_compass;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getApplicable_date() {
        return applicable_date;
    }

    public void setApplicable_date(String applicable_date) {
        this.applicable_date = applicable_date;
    }

    public float getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(float min_temp) {
        this.min_temp = min_temp;
    }

    public float getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(float max_temp) {
        this.max_temp = max_temp;
    }

    public float getThe_temp() {
        return the_temp;
    }

    public void setThe_temp(float the_temp) {
        this.the_temp = the_temp;
    }

    public float getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(float wind_speed) {
        this.wind_speed = wind_speed;
    }

    public float getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(float wind_direction) {
        this.wind_direction = wind_direction;
    }

    public float getAir_pressure() {
        return air_pressure;
    }

    public void setAir_pressure(float air_pressure) {
        this.air_pressure = air_pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public float getVisibility() {
        return visibility;
    }

    public void setVisibility(float visibility) {
        this.visibility = visibility;
    }

    public int getPredictability() {
        return predictability;
    }

    public void setPredictability(int predictability) {
        this.predictability = predictability;
    }
}
