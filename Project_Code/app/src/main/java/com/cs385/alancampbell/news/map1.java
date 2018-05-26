package com.cs385.alancampbell.news;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

//Created by Alan Campbell & Cathal McCabe

public class map1 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;                                 //creates the map object

    @Override
    protected void onCreate(Bundle savedInstanceState) {    //sets the contents appropriately
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map1);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;                                                   //sets the map object to googlemaps

        // Add a marker in Sydney and move the camera
        LatLng Guinness = new LatLng(53.341614, -6.286719);                                     //sets the coordinates into the LatLng object
        mMap.addMarker(new MarkerOptions().position(Guinness).title("Guinness Storehouse"));    //this sets the marker on the position on the map
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Guinness));                               //This moves the camera to the appropriate position
    }

    public void nextLocation (View view) {                                  //This activates the next map page on a button click
        Intent startNewActivity = new Intent(this, map2.class);
        startActivity(startNewActivity);
    }
}
