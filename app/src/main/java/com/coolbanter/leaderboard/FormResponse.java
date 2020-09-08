package com.coolbanter.leaderboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.net.URL;

import retrofit2.http.Field;
import retrofit2.http.Url;

public class FormResponse {

    @SerializedName("Email Address")
    @Expose
    private String emailAddress;

    @SerializedName("Name")
    @Expose
    private String firstName;

    @SerializedName("Last Name")
    @Expose
    private String lastName;


    @SerializedName("Link to Project")
    @Expose
    private URL projectLink;

    public FormResponse(String emailAddress, String firstName, String lastName, URL projectLink) {
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.projectLink = projectLink;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public URL getProjectLink() {
        return projectLink;
    }


}
