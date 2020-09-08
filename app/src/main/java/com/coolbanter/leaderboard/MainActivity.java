package com.coolbanter.leaderboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {



    ViewPager2 viewPager2;
    FragmentStateAdapter mPagerAdapter;
    FragmentManager mFragmentManager;

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
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position) {
                            case 0:
                                tab.setText(R.string.tab_one_name);
                                break;

                            case 1:
                                tab.setText(R.string.tab_two_name);
                                break;
                        }


                    }
                });


        tabLayoutMediator.attach();

    }


    public void submitForm(View view) {



//        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
//        builder.setMessage(R.string.dialog_confirm_submission)
//                .setPositiveButton(R.string.positive, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                })
//                .setNegativeButton(R.string.negative, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//
//                    }
//                });
//        builder.create();
//        builder.show();

        Intent intent = new Intent(MainActivity.this, FormActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();



    }
}