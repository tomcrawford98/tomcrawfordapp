package com.example.tomcrawfordapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class RecipeLog extends Fragment {



    public RecipeLog() {
        FloatingActionButton fab = getActivity().findViewById(R.id.fab);
        fab.setImageResource (R.drawable.ic_add_location_black_24dp);
        fab.setOnClickListener (new View.OnClickListener () {
 @Override
 public void onClick (View view) {
                 Snackbar.make(view, " Home␣Fragment␣Action␣Button ", Snackbar.LENGTH_LONG ).setAction(" Action ", null ).show();
                 }
 });

        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe_log, container, false);

    }
}