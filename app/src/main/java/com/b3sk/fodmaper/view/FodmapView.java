package com.b3sk.fodmaper.view;

import com.b3sk.fodmaper.model.Food;

import java.util.List;

/**
 * Created by Joopk on 4/8/2016.
 */
public interface FodmapView {

    void animateToFilter(List<Food> foodList);
    void bindFoods(List<Food> foodList);
}
