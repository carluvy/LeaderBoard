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

import java.util.Collections;

public class ScoresFragment extends Fragment {


    private ScoresAdapter mScoresAdapter;
    private RecyclerView mRecyclerView;

    public ScoresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_score,
                container, false);

//        scoresData = view.findViewById(R.id.name_iq);

        mRecyclerView = view.findViewById(R.id.recyclerview_iq);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mRecyclerView.setNestedScrollingEnabled(false);
//        List<LeaderBoard> scores = new ArrayList<>();
//        mScoreAdapter = new ScoresAdapter(scores);
        mRecyclerView.setAdapter(mScoresAdapter);
        getScoresData();

        return view;
    }

    private void getScoresData() {

        //    TextView scoresData;
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        LeaderBoardViewModel leaderboardViewModel = new ViewModelProvider(this)
                .get(LeaderBoardViewModel.class);
        leaderboardViewModel.getScores().observe(getViewLifecycleOwner(), leaderBoardList -> {
            mScoresAdapter = new ScoresAdapter(getContext(), leaderBoardList);
            mRecyclerView.setAdapter(mScoresAdapter);

            mScoresAdapter.setScoreList(leaderBoardList);
            mScoresAdapter.notifyDataSetChanged();

            Collections.sort(leaderBoardList, (scoreHigh, scoreLow) ->
                    Integer.compare(scoreLow.getScore(), scoreHigh.getScore()));




        });

        progressDialog.dismiss();

    }


}

