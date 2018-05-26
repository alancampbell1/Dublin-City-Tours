package com.cs385.alancampbell.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Array;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;          //Firebase libraries imported regarding Firebase Databases
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

//The purpose of this Subscription.java page is to provide the user with the ability to input information to the app and it is saved
//to a firebase database online

//Created by Alan Campbell & Cathal McCabe

public class Subscription extends AppCompatActivity {

    //A series of variables of type widgets are created. In onCreate, they will be matched up accordingly with the widgets
    //from the XML
    private EditText mChildValueEditText;
    private EditText minsertText;
    private RadioGroup mRadioGender;
    private  RadioGroup mRadioAge;

    //These variables will hold user information that will be pushed to the database
    String gender;
    String ageGroup;
    String country = "";

    //Button object created. This will be linked to the Subscribe button in the XML
    private Button mAddButton;


    private DatabaseReference mDatabase;
    private TextView mNameView;
    String [] myArray = new String[6];

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription);

        //The following gets access to all the widgets created in the accompanying XML file
        mChildValueEditText = (EditText) findViewById(R.id.childValueEditText);
        minsertText = (EditText) findViewById(R.id.insertName);
        mAddButton = (Button) findViewById(R.id.addButton);
        mRadioGender = (RadioGroup) findViewById(R.id.radioGender);
        mRadioAge = (RadioGroup) findViewById(R.id.radioAge);
        spinner = (Spinner) findViewById(R.id.countryOfOrigin);


        mDatabase = FirebaseDatabase.getInstance().getReference().child("Countries");

        adapter = ArrayAdapter.createFromResource(this,R.array.Country_of_Origin, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            //The following methods are created to carry out an action depending on how the user sets data from the spinner
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //The value that is selected is assigned to the String variable country
                country = adapterView.getItemAtPosition(i).toString();

            }

            //If nothing is selected, a default piece of text is assigned to country
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                country = "Not Stated";
            }
        });

        //Firebase Database object created
        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        //When the Subcription button is selected the following block of code will be executed
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sample = country;

                final DatabaseReference nRef = database.getReference("User Subscription: ");  //The firebase database nRef will be accessed
                String userEmail = mChildValueEditText.getText().toString();                //The email info. the user typed in will be
                //saved to the String userEmail
                String userName = minsertText.getText().toString();                         //This is repeated with name

                onRadioButtonClicked(mRadioGender);                                         //The methods relating to the radio buttons
                onRadioButtonClicked2(mRadioAge);                                           //are called. These assign values based on
                //what options the user selects

                if (!TextUtils.isEmpty(userEmail)) {                                        //This if statement is vital to allowing
                    //new entries to be added to the database
                    String id = nRef.push().getKey();                                       //This creates a unique ID for every entry to
                    //the database, vital when they grow over time

                    Information details = new Information(userEmail, userName, gender, ageGroup, sample);   //object of type details.java
                    //with values sent

                    nRef.child(id).setValue(details);                                       //this method adds the details to the database

                }

                mChildValueEditText.setText("");            //This resets the email editText line to blank after inputting details
                minsertText.setText("");                    //This does the same but the editText line on name details

                Toast.makeText(Subscription.this, "Thank you for submitting your information", Toast.LENGTH_SHORT).show();
                //The toast is a very short piece of text that tells the user their details have been accepted

            }
        });
    }

    //This method concerns the Radio Button regarding Gender
    public void onRadioButtonClicked(RadioGroup radioGender) {      //The radio button is passed in as an object variable


        if (radioGender.getCheckedRadioButtonId() == -1){           //A in-built method that checks what value is selected is compared
            gender = "Not Specified";                           //if nothing is selected, "Not Specified" is set to variable "gender"
        }
        else {
            if (radioGender.getCheckedRadioButtonId() == R.id.maleButton){  //This is repeated for the male and female options accordingly
                gender = "Male";

            }
            else if (radioGender.getCheckedRadioButtonId() == R.id.femaleButton) {
                gender = "Female";
            }
        }
    }

    //This method concerns the Radio Button regarding Age Group
    public void onRadioButtonClicked2(RadioGroup radioAge){

        if (radioAge.getCheckedRadioButtonId() == -1){                          //if no age group is specified, the variable ageGroup
            ageGroup = "Not Specified";                                         //is assigned "Not Specified"
        }
        else {
            if (radioAge.getCheckedRadioButtonId() == R.id.button017){          //if the first button is selected regarding 0 - 17
                ageGroup = "0 - 17";                                            //ageGroup is assigned a piece of text called "0 - 17"

            }
            else if (radioAge.getCheckedRadioButtonId() == R.id.button1824) {   //This is repeated for the three remaining different
                ageGroup = "18 - 24";                                           //Radio Button options

            }
            else if (radioAge.getCheckedRadioButtonId() == R.id.button2550) {
                ageGroup = "25 - 50";

            }
            else if (radioAge.getCheckedRadioButtonId() == R.id.button50) {
                ageGroup = "Over 50";

            }
        }
    }
}