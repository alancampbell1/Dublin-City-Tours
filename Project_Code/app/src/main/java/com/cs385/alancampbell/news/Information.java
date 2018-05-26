package com.cs385.alancampbell.news;

/**
 * Created by Alan Campbell & Cathal McCabe
 *
 * The purpose of this Information.java is to provide an object that contains all the information from the user in the Subscription section
 * of the app and allows us to send the data as one group to the Firebase database
 */

public class Information {

    String email;           //global string variables
    String name;
    String gender;
    String ageGroup;
    String country;

    public Information(){       //default blank constructor with no parameters

    }

    //This parameterised constructor also acts as a setter method for assigning values to the String variables above

    public Information (String email, String name, String gender, String ageGroup, String country){
        this.email = email;
        this.name = name;
        this.gender = gender;
        this.ageGroup = ageGroup;
        this.country = country;
    }

    //The following is a list of getter methods, each associated with a particular String
    public String getEmail(){
        return email;
    }
    public String getName(){
        return name;
    }
    public String getGender(){
        return gender;
    }
    public String getAgeGroup(){
        return ageGroup;
    }
    public String getCountry() { return country; }
}
