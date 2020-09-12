package com.coolbanter.leaderboard;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.net.URL;



import java.util.List;

public class ScoresAdapter extends RecyclerView.Adapter<ScoresAdapter.ScoreViewHolder> {



    List<LeaderBoard> mScoreList;
    Context mContext;


    ScoresAdapter(Context context, List<LeaderBoard> scoreList) {
        mScoreList = scoreList;
        mContext = context;


    }


    @NonNull
    @Override
    public ScoresAdapter.ScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.score_item_list, parent, false);
        return new ScoreViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ScoreViewHolder holder, int position) {
        LeaderBoard scores = mScoreList.get(position);

        String fullText = "";
        holder.mName.setText(scores.getName());
        fullText += scores.getScore() + " skillsIQ, ";
        fullText += scores.getCountry() +"\n\n";
        holder.mScore.append(fullText);

        URL badgeUrl = mScoreList.get(position).getBadgeUrl();
        Picasso.get()
                .load(String.valueOf(badgeUrl))
                .placeholder(R.drawable.skill_iq_trimmed)
                .fit()
                .centerInside()
                .into(holder.mProfile);
        holder.setIsRecyclable(false);






    }


    @Override
    public int getItemCount() {
        int limit = 20;
        return Math.min(mScoreList.size(), limit);

    }

    public void setScoreList(List<LeaderBoard> leaderBoardList) {
        mScoreList = leaderBoardList;

    }


    public static class ScoreViewHolder extends RecyclerView.ViewHolder {

        TextView mName;
        ImageView mProfile;
        TextView mScore;

        public ScoreViewHolder(@NonNull View itemView) {
            super(itemView);
            mName =itemView.findViewById(R.id.name_iq);
            mProfile = itemView.findViewById(R.id.profile_pic);
            mScore = itemView.findViewById(R.id.score);
        }
    }
}
