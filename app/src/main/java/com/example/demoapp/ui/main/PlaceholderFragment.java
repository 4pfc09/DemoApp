package com.example.demoapp.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.demoapp.adapters.ContentAdapter;
import com.example.demoapp.databinding.FragmentBuiltInTabbedBinding;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private FragmentBuiltInTabbedBinding binding;
    //++
    private int currentIndex = 1;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);

        if (getArguments() != null) {
            currentIndex = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(currentIndex);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentBuiltInTabbedBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.sectionLabel;
        //++
        final GridView gridView = binding.griViewdBuiltInFragment;
        gridView.setAdapter(new ContentAdapter(container.getContext(), this.currentIndex));

        pageViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
                //++
                Log.println(Log.DEBUG, "debug fragment", String.valueOf(pageViewModel.getCurrentIndex()));
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}