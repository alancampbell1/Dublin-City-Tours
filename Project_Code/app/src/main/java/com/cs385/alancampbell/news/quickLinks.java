package com.cs385.alancampbell.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

//Created by Alan Campbell & Cathal McCabe

//The purpose of this quickLinks.java file is to provide access to the different URL's from the users selection of the different image
//buttons in the accompanying XML


public class quickLinks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_links);
    }
                                                                                                    // simple browers methods to creates links to website
    public void luaslink(View view)
    {                                                                                               //creates browersIntent for the button luaslink
        Intent browserIntenet = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.luas.ie"));
        startActivity(browserIntenet);                                                              // link to www.luas.ie, links to website
    }

    public void buslink(View view)                                                                  // repeated process same as luaslink method
    {
        Intent browserIntenet = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.dublinbus.ie"));
        startActivity(browserIntenet);
    }
    public void raillink(View view)                                                                 // repeated process same as luaslink method
    {
        Intent browserIntenet = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.irishrail.ie"));
        startActivity(browserIntenet);
    }

    public void buseireannlink(View view)                                                           // repeated process same as luaslink method
    {
        Intent browserIntenet = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.buseireann.ie"));
        startActivity(browserIntenet);
    }

    public void lynklink(View view)                                                                 // repeated process same as luaslink method
    {
        Intent browserIntenet = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.lynk.ie"));
        startActivity(browserIntenet);
    }
    public void dublinalink(View view)                                                              // repeated process same as luaslink method
    {
        Intent browserIntenet = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dublinia.ie"));
        startActivity(browserIntenet);
    }

    public void zoolink(View view)                                                                  // repeated process same as luaslink method
    {
        Intent browserIntenet = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.dublinzoo.ie/"));
        startActivity(browserIntenet);
    }
}
