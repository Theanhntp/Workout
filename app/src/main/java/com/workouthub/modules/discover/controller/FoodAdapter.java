package com.workouthub.modules.discover.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.workouthub.R;
import com.workouthub.entity.food.Food;

import java.util.List;

public class FoodAdapter extends ArrayAdapter {
    private Context mCtx;
    private int resources;
    private List<Food> items;

    public FoodAdapter(Context mCtx, int resources, List<Food> items) {
        super(mCtx, resources, items);
        this.mCtx = mCtx;
        this.resources = resources;
        this.items = items;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater var = LayoutInflater.from(this.mCtx);
        LayoutInflater layoutInflater = var;
        View var10 = layoutInflater.inflate(this.resources, (ViewGroup) null);
        View view = var10;
        var10 = view.findViewById(R.id.food_image);
        ImageView imageView = (ImageView) var10;
        var10 = view.findViewById(R.id.foodNameText);
        TextView titleTextView = (TextView) var10;
        var10 = view.findViewById(R.id.foodDescription);
        TextView despTextView = (TextView) var10;
        Food mItem = (Food) this.items.get(position);
        imageView.setImageDrawable(this.mCtx.getResources().getDrawable(mItem.getImg()));
        titleTextView.setText((CharSequence) mItem.getTitle());
        despTextView.setText((CharSequence) mItem.getDescription());
        return view;
    }

    public final Context getMCtx() {
        return this.mCtx;
    }

    public final void setMCtx(Context var1) {
        this.mCtx = var1;
    }

    public final int getResources() {
        return this.resources;
    }

    public final void setResources(int var1) {
        this.resources = var1;
    }

    public final List<Food> getItems() {
        return this.items;
    }

    public final void setItems(List<Food> var1) {
        this.items = var1;
    }
}