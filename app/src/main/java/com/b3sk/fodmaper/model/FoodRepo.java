package com.b3sk.fodmaper.model;

import java.util.List;

/**
 * Created by Joopkins on 6/18/16.
 */
public interface FoodRepo {

    List<Food> getFodmaps();
    List<Food> getModerates();
    List<Food> getFruits();
    List<Food> getVeggies();
    List<Food> getProtein();
    List<Food> getGrains();
    List<Food> getOthers();
    List<Food> getAllFood();
}
