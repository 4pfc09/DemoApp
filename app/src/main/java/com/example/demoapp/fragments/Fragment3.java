package com.example.demoapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import com.example.demoapp.R;
import com.example.demoapp.adapters.ImageGridAdapter;
import com.example.demoapp.model.Content;

import java.util.ArrayList;
import java.util.List;


public class Fragment3 extends Fragment {
    List<Content> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_1, container, false);
        GridView gridView = vista.findViewById(R.id.gridView);
        String[] text = {"Statue", "Perro", "Estatua china"};
        int[] images = {R.drawable.statue, R.drawable.dog, R.drawable.china};
        list = new ArrayList<>();
        for (int i = 0; i <= text.length - 1; i++) {
            list.add(new Content(text[i], images[i]));
        }
        ImageGridAdapter gridAdapter = new ImageGridAdapter(list, this.getContext());
        gridView.setAdapter(gridAdapter);
        return vista;
    }

}