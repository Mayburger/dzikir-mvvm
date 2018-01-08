package com.nacoda.dzikir_mvvm;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    String[] data = {"hey","heyhasiud","haydshasuydh"};
    ViewPager vpData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vpData = findViewById(R.id.vpData);

        PagerAdapter adapter = new ViewPagerAdapter(getApplicationContext(), data);
        vpData.setAdapter(adapter);


    }
}
