package com.example.tomcrawfordapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.tomcrawfordapp.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final TextView textView = view.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        LinearLayout layout = view.findViewById(R.id.breakfast);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragmentDirections.ActionNavHomeToViewBreakfastFragment action =
                        HomeFragmentDirections.actionNavHomeToViewBreakfastFragment("breakfast");

                NavHostFragment.findNavController(HomeFragment.this)
                        .navigate(action);
            }
        });
        LinearLayout layout1 = view.findViewById(R.id.lunch);
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragmentDirections.ActionNavHomeToViewBreakfastFragment action =
                        HomeFragmentDirections.actionNavHomeToViewBreakfastFragment("lunch");

                NavHostFragment.findNavController(HomeFragment.this)
                        .navigate(action);
            }
        });

        LinearLayout layout2 = view.findViewById(R.id.dinner);
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragmentDirections.ActionNavHomeToViewBreakfastFragment action =
                        HomeFragmentDirections.actionNavHomeToViewBreakfastFragment("dinner");

                NavHostFragment.findNavController(HomeFragment.this)
                        .navigate(action);
            }
        });

        LinearLayout layout3 = view.findViewById(R.id.snacks);
        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragmentDirections.ActionNavHomeToViewBreakfastFragment action =
                        HomeFragmentDirections.actionNavHomeToViewBreakfastFragment("snacks");

                NavHostFragment.findNavController(HomeFragment.this)
                        .navigate(action);
            }
        });

        LinearLayout layout4 = view.findViewById(R.id.dessert);
        layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragmentDirections.ActionNavHomeToViewBreakfastFragment action =
                        HomeFragmentDirections.actionNavHomeToViewBreakfastFragment("dessert");

                NavHostFragment.findNavController(HomeFragment.this)
                        .navigate(action);
            }
        });
    }
}