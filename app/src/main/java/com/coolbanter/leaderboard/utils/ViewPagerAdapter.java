package com.coolbanter.leaderboard.utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.coolbanter.leaderboard.HoursFragment;
import com.coolbanter.leaderboard.ScoresFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new HoursFragment();
        } else {
            return new ScoresFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
