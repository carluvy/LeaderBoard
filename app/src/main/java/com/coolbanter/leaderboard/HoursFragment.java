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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HoursFragment extends Fragment {

    HoursAdapter mHoursAdapter;
    private TextView hoursData;

    public HoursFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hours, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_ll);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setNestedScrollingEnabled(false);
        List<LeaderBoard> hoursList = new ArrayList<>();
        mHoursAdapter = new HoursAdapter(hoursList);
        recyclerView.setAdapter(mHoursAdapter);

        hoursData = view.findViewById(R.id.name);

        getData();

        return view;
    }

    private void getData() {

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();


//        HoursApiService hoursApiService = mRetrofit.create(HoursApiService.class);

        APIService hoursApiService = LeaderBoardApiClient.getHourService();


        Call<List<LeaderBoard>> call = hoursApiService.getHours();
        call.enqueue(new Callback<List<LeaderBoard>>() {
            @Override
            public void onResponse(Call<List<LeaderBoard>> call,
                                   Response<List<LeaderBoard>> response) {

                if (!response.isSuccessful()) {

                    hoursData.setText("code: " + response.code());
                    return;
                }


                List<LeaderBoard> hoursList = response.body();


                assert hoursList != null;
                Collections.sort(hoursList, new Comparator<LeaderBoard>() {
                    @Override
                    public int compare(LeaderBoard hoursMany, LeaderBoard hoursLess) {
                        return Integer.compare(hoursLess.getHours(), hoursMany.getHours());
                    }
                });

                mHoursAdapter.setHourList(hoursList);
                mHoursAdapter.notifyDataSetChanged();

                progressDialog.dismiss();




            }

            @Override
            public void onFailure(Call<List<LeaderBoard>> call, Throwable t) {
                Log.e("failure", Objects.requireNonNull(t.getLocalizedMessage()));


            }


        });
    }


}