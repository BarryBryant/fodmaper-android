package com.b3sk.fodmaper.helpers;

import com.b3sk.fodmaper.models.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joopk on 3/27/2016.
 */
public class FoodFilter {

    public static List<Food> filter(List<Food> foods, String query) {
        query = query.toLowerCase();

        final List<Food> filteredFoodList = new ArrayList<>();
        for (Food food : foods) {
            final String text = food.getName().toLowerCase();
            if (text.contains(query)) {
                filteredFoodList.add(food);
            }
        }
        return filteredFoodList;
    }
}
