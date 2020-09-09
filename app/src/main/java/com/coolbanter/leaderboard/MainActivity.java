package com.coolbanter.leaderboard;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;



public class MainActivity extends AppCompatActivity {



    ViewPager2 viewPager2;
    FragmentStateAdapter mPagerAdapter;
//    FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar myToolbar = findViewById(R.id.my_tool_bar);
        setSupportActionBar(myToolbar);


        viewPager2 = findViewById(R.id.view_pager);
        mPagerAdapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(mPagerAdapter);




        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText(R.string.tab_one_name);
                            break;

                        case 1:
                            tab.setText(R.string.tab_two_name);
                            break;
                    }


                });


        tabLayoutMediator.attach();

    }


    public void submitForm(View view) {
        Intent intent = new Intent(MainActivity.this, FormActivity.class);
        startActivity(intent);
        finish();



    }
}