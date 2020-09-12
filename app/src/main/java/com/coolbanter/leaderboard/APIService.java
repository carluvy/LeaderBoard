package com.coolbanter.leaderboard;


import java.util.List;



import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface APIService {
    @GET("/api/skilliq")
    Call<List<LeaderBoard>> getScores();

    @GET("/api/hours")
    Call<List<LeaderBoard>> getHours();

    @FormUrlEncoded
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    Call<Void> submitDetails(
    @Field("entry.1824927963")
     String emailAddress,
    @Field("entry.1877115667")
    String firstName,
    @Field("entry.2006916086")
    String lastName,
    @Field("entry.284483984")
    String projectLink);







}
