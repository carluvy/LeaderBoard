package com.coolbanter.leaderboard;



import android.util.Log;




import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeaderBoardViewModel extends ViewModel {

    private MutableLiveData<List<LeaderBoard>> leaderBoardScores;
    private MutableLiveData<List<LeaderBoard>> leaderBoardHours;


    public LiveData<List<LeaderBoard>> getScores() {
        if (leaderBoardScores == null) {
            leaderBoardScores = new MutableLiveData<>();
            loadScores();
        }
        return leaderBoardScores;
    }


    private void loadScores() {
        APIService scoreAPIService = LeaderBoardApiClient.getScoresService();


        Call<List<LeaderBoard>> call = scoreAPIService.getScores();

        call.enqueue(new Callback<List<LeaderBoard>>() {
            @Override
            public void onResponse(Call<List<LeaderBoard>> call, Response<List<LeaderBoard>> response) {

                if (response.isSuccessful()) {

                    Log.i("OnSuccess", "code: " + response.code());

                }
                leaderBoardScores.setValue(response.body());

            }

            @Override
            public void onFailure(Call<List<LeaderBoard>> call, Throwable t) {

                Log.e("failure", t.getLocalizedMessage());
//                Toast.makeText( LeaderBoardViewModel.th, "An error occurred", Toast.LENGTH_SHORT).show();


            }


        });

    }

    public LiveData<List<LeaderBoard>>getHours(){

        if (leaderBoardHours == null) {
            leaderBoardHours = new MutableLiveData<>();
            loadHours();
        }

        return leaderBoardHours;

    }



    private void loadHours() {

        APIService hoursApiService = LeaderBoardApiClient.getHourService();


        Call<List<LeaderBoard>> call = hoursApiService.getHours();
        call.enqueue(new Callback<List<LeaderBoard>>() {
            @Override
            public void onResponse(Call<List<LeaderBoard>> call, Response<List<LeaderBoard>> response) {

                if (response.isSuccessful()) {
                    Log.i("OnSuccess", "code: " + response.code());
                }
                leaderBoardHours.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<LeaderBoard>> call, Throwable t) {

                Log.e("failure", t.getLocalizedMessage());

            }
        });

    }


}
