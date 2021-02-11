package com.example.tomcrawfordapp.model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "food_table")
public class Food {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "food")
    private String mFood;


    public Food(@NonNull String food) {
        this.mFood = food;
    }

    public String getFood() {
        return this.mFood;
    }
}