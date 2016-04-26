package com.b3sk.fodmaper.data;

import com.b3sk.fodmaper.model.Food;

import java.util.List;

/**
 * Created by Joopk on 4/23/2016.
 */
public interface foodLoader {

    void onDataLoaded(List<Food> foodList, String key);
}
