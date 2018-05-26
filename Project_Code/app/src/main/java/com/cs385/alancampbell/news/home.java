package com.cs385.alancampbell.news;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

//Created by Alan Campbell & Cathal McCabe

//The purpose of this home.java file is to provide access to the different activities on the home page to the different sections of our
//app. Each button click will bring the user to a different section of the app

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void News (View view) {
        Intent startNewActivity = new Intent(this, MainActivity.class);
        startActivity(startNewActivity);
    }

    public void Subscription (View view) {
        Intent startNewActivity = new Intent(this, Subscription.class);
        startActivity(startNewActivity);
    }

    public void weather (View view) {
        Intent startNewActivity = new Intent(this, weather.class);
        startActivity(startNewActivity);
    }

    public void Links (View view) {
        Intent startNewActivity = new Intent(this, quickLinks.class);
        startActivity(startNewActivity);
    }

    public void Quiz (View view) {
        Intent startNewActivity = new Intent(this, Quiz.class);
        startActivity(startNewActivity);
    }

    public void tour (View view) {
        Intent startNewActivity = new Intent(this, map1.class);
        startActivity(startNewActivity);
    }
}