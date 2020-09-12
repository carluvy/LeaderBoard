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

public class HoursAdapter extends RecyclerView.Adapter<HoursAdapter.HoursViewHolder>{

    List<LeaderBoard> mHoursList;
    Context mContext;

    HoursAdapter(Context context, List<LeaderBoard> hoursList) {
        mHoursList = hoursList;
        mContext = context;

    }


    @NonNull
    @Override
    public HoursAdapter.HoursViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.hours_item_list, parent, false);
        return new HoursAdapter.HoursViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HoursViewHolder holder, int position) {
        LeaderBoard hours = mHoursList.get(position);

        String fullText = "";
        holder.mName.setText(hours.getName());
        fullText += hours.getHours() + " learning hours, ";
        fullText += hours.getCountry();
        holder.mHours.append(fullText);

        URL imageUrl = mHoursList.get(position).getBadgeUrl();

        Picasso.get()
                .load(String.valueOf(imageUrl))
                .placeholder(R.drawable.top_learner)
                .fit()
                .centerInside()
                .into(holder.mProfile);
        holder.setIsRecyclable(false);

    }

    @Override
    public int getItemCount() {
        int limit = 20;
        return Math.min(mHoursList.size(), limit);
    }

    public void setHourList(List<LeaderBoard> hourList) {
        mHoursList = hourList;
    }

    public static class HoursViewHolder extends RecyclerView.ViewHolder {

        TextView mName;
        ImageView mProfile;
        TextView mHours;

        public HoursViewHolder(@NonNull View itemView) {
            super(itemView);
            mName =itemView.findViewById(R.id.name);
            mProfile = itemView.findViewById(R.id.profile_pic2);
            mHours = itemView.findViewById(R.id.hours);

        }
    }
}


