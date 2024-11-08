package com.workouthub.modules.discover.provider;

import android.content.Context;

import com.workouthub.entity.food.Food;

import java.util.List;

public class FoodProvider extends IFoodProvider {
    public FoodProvider(Context context) {
        super(context);
    }

    public List<Food> getFoods() {
        return repo.getFood().getAll();
    }
}
