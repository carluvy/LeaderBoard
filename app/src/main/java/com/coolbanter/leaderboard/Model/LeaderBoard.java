package com.coolbanter.leaderboard.Model;



import com.google.gson.annotations.SerializedName;

import java.net.URL;

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




    public int getHours() {
        return hours;
    }




    public int getScore() {
        return score;
    }



    public String getCountry() {
        return country;
    }



    public URL getBadgeUrl() {
        return badgeUrl;
    }


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
