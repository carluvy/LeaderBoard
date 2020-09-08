package com.coolbanter.leaderboard;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScoreFragment extends Fragment {


    private ScoreAdapter mScoreAdapter;
    TextView scoresData;

    public ScoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_score,
                container, false);

        scoresData = view.findViewById(R.id.name_iq);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_iq);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setNestedScrollingEnabled(false);
        List<LeaderBoard> scores = new ArrayList<>();
        mScoreAdapter = new ScoreAdapter(scores);
        recyclerView.setAdapter(mScoreAdapter);
//        getAllData();

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();


//        APIService scoreApi = mRetrofit.create(APIService.class);

        APIService scoreAPIService = ApiClient.getScoresService();


        Call<List<LeaderBoard>> call = scoreAPIService.getScores();

        call.enqueue(new Callback<List<LeaderBoard>>() {
            @Override
            public void onResponse(Call<List<LeaderBoard>> call, Response<List<LeaderBoard>> response) {

                if (!response.isSuccessful()) {

                    scoresData.setText("code: " + response.code());
                    return;
                }


                List<LeaderBoard> scoresList = response.body();


                assert scoresList != null;
                Collections.sort(scoresList, new Comparator<LeaderBoard>() {
                    @Override
                    public int compare(LeaderBoard scoreHigh, LeaderBoard scoreLow) {
                        return Integer.compare(scoreLow.getScore(), scoreHigh.getScore());


                    }

                });
                mScoreAdapter.setScoreList(scoresList);
                mScoreAdapter.notifyDataSetChanged();

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<LeaderBoard>> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());
                progressDialog.dismiss();
                Toast.makeText(getContext(), "An error occurred", Toast.LENGTH_SHORT).show();

            }


        });

        return view;
    }


}

