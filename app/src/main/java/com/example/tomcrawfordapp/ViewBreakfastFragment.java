package com.example.tomcrawfordapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tomcrawfordapp.model.FoodListAdapter;
import com.example.tomcrawfordapp.ui.home.HomeFragment;
import com.example.tomcrawfordapp.ui.home.HomeFragmentDirections;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewBreakfastFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_breakfast, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewBreakfastFragmentArgs args = ViewBreakfastFragmentArgs.fromBundle(getArguments());
        String mealName = args.getMealName();
        TextView title = view.findViewById(R.id.label_food);
        title.setText(mealName);

        Button button = view.findViewById(R.id.create_food_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ViewBreakfastFragment.this)
                        .navigate(R.id.createRecipeFragment, null);
            }
        });

    }
}