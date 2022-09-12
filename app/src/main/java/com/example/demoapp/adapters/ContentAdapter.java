package com.example.demoapp.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.demoapp.fragments.Fragment1;
import com.example.demoapp.fragments.Fragment2;
import com.example.demoapp.fragments.Fragment3;

public class ContentAdapter extends FragmentStateAdapter {

    public ContentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Fragment1();
            case 1:
                return new Fragment2();
            default:
                return new Fragment3();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
