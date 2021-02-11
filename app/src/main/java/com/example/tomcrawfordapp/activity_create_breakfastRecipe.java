package com.example.tomcrawfordapp;

import android.app.DatePickerDialog;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class activity_create_breakfastRecipe extends AppCompatActivity {

    private TextView textViewRecipeName, textViewRecipeDate;
    private Button RecipeStartDate;

    private final Calendar c = Calendar.getInstance();
    private int mYear, mMonth, mDay;
    private Boolean validDate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_breakfast_recipe);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textViewRecipeDate = findViewById(R.id.RecipeDate);
        textViewRecipeDate.setEnabled(false);

        RecipeStartDate = findViewById(R.id.RecipeStartDate);
        RecipeStartDate.setOnClickListener((View.OnClickListener) this);



    }
}