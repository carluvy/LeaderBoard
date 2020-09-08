package com.coolbanter.leaderboard;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.net.URL;
import java.util.List;

public  class LeaderBoard {



    @SerializedName("name")
    private String name;


    @SerializedName("hours")
    private int hours;


    @SerializedName("score")
    private int score;


    @SerializedName("country")
    private String country;


    @SerializedName("badgeUrl")
    private URL badgeUrl;

    public LeaderBoard( String name,  int hours,  int score,
                        String country,  URL badgeUrl) {
        this.name = name;
        this.hours = hours;
        this.score = score;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }


    public String getName() {
        return name;
    }

//    public void setName( String name) {
//        this.name = name;
//    }


    public int getHours() {
        return hours;
    }

//    public void setHours( String hours) {
//        this.hours = hours;
//    }


    public int getScore() {
        return score;
    }

//    public void setScore( String score) {
//        this.score = score;
//    }


    public String getCountry() {
        return country;
    }

//    public void setCountry( String country) {
//        this.country = country;
//    }


    public URL getBadgeUrl() {
        return badgeUrl;
    }

//    public void setBadgeUrl( String badgeUrl) {
//        this.badgeUrl = badgeUrl;    }

//    @Override
//    public String toString() {
//        return "LeaderBoard{" +
//                "name='" + name + '\'' +
//                ", hours='" + hours + '\'' +
//                ", score='" + score + '\'' +
//                ", country='" + country + '\'' +
//                ", badgeUrl='" + badgeUrl + '\'' +
//                '}';
//    }
}
