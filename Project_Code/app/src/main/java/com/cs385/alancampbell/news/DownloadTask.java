package com.cs385.alancampbell.news;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ListView;
import org.json.JSONObject;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.cs385.alancampbell.news.weather.HumidityTextView;
import static com.cs385.alancampbell.news.weather.placeTextView;
import static com.cs385.alancampbell.news.weather.temperatureTextView;
import static com.cs385.alancampbell.news.weather.weatherTextView;
import static com.cs385.alancampbell.news.weather.windSpeedTextView;

/**
 * Created by Alan Campbell & Cathal McCabe
 * The purpose of this DownloadTask.java file is to connect to the weather API and extract its information relating to Dublin
 *
 */

public class DownloadTask extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... urls){                        //This method accesses the online data

        String result = "";                                                 //Blank String to hold certain results
        URL url;                                                            //URL object created
        HttpURLConnection urlConnection = null;                             //HttpURLConnection created

        try {                                                               //This try statement reads in the URL to access the data
            url = new URL(urls[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            int data = reader.read();

            while (data !=  -1){                            //While loop which stores the data
                char current = (char) data;
                result += current;
                data = reader.read();
            }

            return result;

        }catch (Exception e){                               //Exception added incase errors occur
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {           //This method reads in the data as a String
        super.onPostExecute(result);

        try{
            JSONObject jsonObject = new JSONObject(result);                                         //A JSONobject is created

            JSONObject weatherData = new JSONObject(jsonObject.getString("main"));                  //Another object created relating to 'main' text
            Double temperature = Double.parseDouble(weatherData.getString("temp"));                 //repeated for temperature

            int temperatureInteger = (int) (temperature * 1.8 - 459.67);                            //converts kelvin to Fahernheit
            int celTemp = (int) ((temperatureInteger - 32) * 0.5556);                               //converts to Celsius
            String placeName  = jsonObject.getString("name");                                       //gets the station name from JSONobject
            String placeNameConCate = "This was recorded at a weather station in " + placeName;     //concates name with piece of text

            String temp = Integer.toString(celTemp);                //converts int to String

            String weather = jsonObject.getString("weather");       //Gets the weather data component of API key

            String [] items = weather.split("\"");                  //Divided up according to a "
            List<String> itemList = new ArrayList<String>();             //ArrayList created
            for(String item: items){                                //adds the Array String items to an ArrayList
                itemList.add(item);
            }
            String answer = itemList.get(9);                        //The nineth element refers to Cloud Cover

            if(celTemp == 1 || celTemp == -1) {                     //Concates Temperature String depending on what what temperature it is
                temp = temp + "°C";
            }
            else {

                temp = temp + "°C";
            }

            String humidity  = weatherData.getString("humidity");                   //Stores the humidity from the JSONobject in a String
            humidity = "Humidity: " + humidity + "%";                             //Concates humidity String with a piece of text


            String windSpeed = jsonObject.getString("wind");
            String [] items2 = windSpeed.split("\"");
            List<String> itemList2 = new ArrayList<>();
            for(String item: items2){
                itemList2.add(item);
            }
            String windData = itemList2.get(2);
            String specificWindData = windData.substring(1,4);

            String conateWindData = "Wind Speed: " + specificWindData + "km/h";


            temperatureTextView.setText(String.valueOf(temp));         //links the live data with text views in the activity
            placeTextView.setText(String.valueOf(placeNameConCate));
            HumidityTextView.setText(String.valueOf(humidity));
            weatherTextView.setText(String.valueOf(answer));
            windSpeedTextView.setText(String.valueOf(conateWindData));


        } catch (Exception e){                                                      //Catch exception incase there are errors
            e.printStackTrace();
        }
    }
}