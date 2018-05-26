package com.cs385.alancampbell.news;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;

//This SplashScreen.java file is for the purpose of creating a Splash Screen that will show for a period of time and play a piece of recorded music

//Created by Alan Campbell & Cathal McCabe

public class SplashScreen extends AppCompatActivity {

    MediaPlayer ourSound;                                                   //Media Player object created

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ourSound = MediaPlayer.create(this, R.raw.guitar3);                 //Links a MP3 file to the MediaPlayer object
        ourSound.start();

        Thread myThread = new Thread() {
            @Override
            public void run() {
                try {                                                                                   //try statement opened
                    sleep(3000);                                                                        //App runs for 3000 milliseconds
                    Intent startMainScreen = new Intent(getApplicationContext(), home.class);   //Intent opened to go to the Main Activity
                    startActivity(startMainScreen);                                                     //Intent activated to open Main Activity


                    finish();                                                                           //closes Splash Screen
                } catch (InterruptedException e) {                                                      //catch statement to catch an errors
                    e.printStackTrace();
                }
            }


        };
        myThread.start();
    }
    @Override
    protected void onPause() {                                      //onPause method to stop the music playing in a loop
        super.onPause();
        ourSound.release();
        finish();
    }

}