package com.coolbanter.leaderboard;


import android.app.ProgressDialog;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.coolbanter.leaderboard.utils.HoursAdapter;
import com.coolbanter.leaderboard.viewModel.LeaderBoardViewModel;


import java.util.Collections;



public class HoursFragment extends Fragment {

    HoursAdapter mHoursAdapter;

    private RecyclerView mRecyclerView;

    public HoursFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hours, container, false);

        mRecyclerView = view.findViewById(R.id.recyclerview_ll);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setAdapter(mHoursAdapter);


        getHoursData();

        return view;
    }

    private void getHoursData() {

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        LeaderBoardViewModel leaderboardViewModel = new ViewModelProvider(this)
                .get(LeaderBoardViewModel.class);
        leaderboardViewModel.getHours().observe(getViewLifecycleOwner(), leaderBoardList -> {
            mHoursAdapter = new HoursAdapter(getContext(), leaderBoardList);
            mRecyclerView.setAdapter(mHoursAdapter);

            mHoursAdapter.setHourList(leaderBoardList);
            mHoursAdapter.notifyDataSetChanged();

            Collections.sort(leaderBoardList, (hoursHigh, hoursLow) ->
                    Integer.compare(hoursLow.getHours(), hoursHigh.getHours()));




        });

        progressDialog.dismiss();

    }






}