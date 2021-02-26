package com.example.tomcrawfordapp.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tomcrawfordapp.R;

import java.util.List;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.FoodViewHolder> {

    class FoodViewHolder extends RecyclerView.ViewHolder {
        private final TextView foodItemView;

        private FoodViewHolder(View itemView) {
            super(itemView);
            foodItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Food> mFood; // Cached copy of food

    public FoodListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new FoodViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position) {
        Food current = mFood.get(position);
        holder.foodItemView.setText(current.getFood());
    }

    void setFood(List<Food> food){
        mFood = food;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mFood has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mFood != null)
            return mFood.size();
        else return 0;
    }

}
