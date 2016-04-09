package com.b3sk.fodmaper.view;

import com.b3sk.fodmaper.models.Food;

import java.util.List;

/**
 * Created by Joopk on 4/9/2016.
 */
public interface FriendlyView {

    void animateToFilter(List<Food> foodList);
    void bindFoods(List<Food> foodList);
    void onFruitClicked(boolean clicked);
    void onVegiClicked(boolean clicked);
    void onMeatClicked(boolean clicked);

}
