package com.example.tomcrawfordapp.model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class FoodViewModel extends AndroidViewModel {

    private FoodRepository mRepository;

    private LiveData<List<Food>> mAllFood;

    public FoodViewModel (Application application) {
        super(application);
        mRepository = new FoodRepository(application);
        mAllFood = mRepository.getAllFood();
    }

    LiveData<List<Food>> getAllFood() { return mAllFood; }

    public void insert(Food food) { mRepository.insert(food); }
}
