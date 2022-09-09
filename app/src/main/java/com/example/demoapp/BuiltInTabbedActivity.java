package com.example.demoapp;

import android.os.Bundle;
import android.util.Log;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.demoapp.databinding.ActivityBuiltInTabbedBinding;
import com.example.demoapp.ui.main.SectionsPagerAdapter;

import com.google.android.material.tabs.TabLayout;

public class BuiltInTabbedActivity extends AppCompatActivity {

    private ActivityBuiltInTabbedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBuiltInTabbedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

        //++

        tabs.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {
            @Override
            public void onTabSelected(@NonNull TabLayout.Tab tab) {
                super.onTabSelected(tab);
                Log.println(Log.DEBUG, "tabSelected", "El index es: " + tab.getId() + " " + tab.getText());
                //tab.tetText() resulta en el texto establecido en resources strings


            }
        });
    }
}