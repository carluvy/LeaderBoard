package com.coolbanter.leaderboard.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


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
    private String projectLink;

    public FormResponse(String emailAddress, String firstName, String lastName, String projectLink) {
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

    public String getProjectLink() {
        return projectLink;
    }


}
