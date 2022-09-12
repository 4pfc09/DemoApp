package com.example.demoapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.demoapp.adapters.ContentAdapter;
import com.example.demoapp.databinding.ActivityBuiltInTabbedBinding;
import com.google.android.material.tabs.TabLayout;

public class BuiltInTabbedActivity extends AppCompatActivity {

    private ActivityBuiltInTabbedBinding binding;
    private TabLayout tabLayout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_built_in_tabbed);
        tabLayout1 = findViewById(R.id.tabLayout1);
        ViewPager2 viewPager2 = findViewById(R.id.viewPager);

        viewPager2.setAdapter(new ContentAdapter(getSupportFragmentManager(), getLifecycle()));
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout1.selectTab(tabLayout1.getTabAt(position));
            }
        });
        tabLayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}