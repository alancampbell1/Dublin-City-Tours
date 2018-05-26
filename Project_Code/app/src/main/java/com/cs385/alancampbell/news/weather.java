package com.cs385.alancampbell.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
//import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

//The purpose of the weather.java file is to pull live weather data from a weather API and display it on the screen

//Created by Alan Campbell & Cathal McCabe

public class weather extends AppCompatActivity {

    static TextView placeTextView;                  //TextView Objects created
    static TextView temperatureTextView;
    static TextView HumidityTextView;
    static TextView weatherTextView;
    static TextView windSpeedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        placeTextView = (TextView) findViewById(R.id.textView);             //links Global TextViews with TextViews in XML
        temperatureTextView = (TextView) findViewById(R.id.textView2);
        HumidityTextView = (TextView) findViewById(R.id.textView9);
        weatherTextView = (TextView) findViewById(R.id.textView10);
        windSpeedTextView = (TextView) findViewById(R.id.textView3);


        DownloadTask task = new DownloadTask();                             //object created of DownloadTask.java
        task.execute("http://api.openweathermap.org/data/2.5/weather?lat=53.3498&lon=-6.2603&appid=c6b0b790234ce78c4373c1b8682916da");
        //The execute command is carried out using the URL above, generated using unique API and LAT/LONG
    }
}