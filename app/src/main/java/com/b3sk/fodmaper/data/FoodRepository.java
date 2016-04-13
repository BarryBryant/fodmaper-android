package com.b3sk.fodmaper.data;

import com.b3sk.fodmaper.model.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joopk on 4/8/2016.
 */
public class FoodRepository {

    public List<Food> getFood() {
        List<Food> allItems = new ArrayList<Food>();
        allItems.add(new Food("Alpha", 1, "Food"));
        allItems.add(new Food("Beta", 1, "Food"));
        allItems.add(new Food("Charlie", 1, "Food"));
        allItems.add(new Food("Delta", 1, "Food"));
        allItems.add(new Food("Echo", 1, "Food"));
        allItems.add(new Food("Foxtrot", 1, "Food"));
        allItems.add(new Food("Gamma", 1, "Food"));
        allItems.add(new Food("Halo", 1, "Food"));
        allItems.add(new Food("Ingrown Hair", 1, "Food"));
        allItems.add(new Food("Janky", 1, "Food"));
        allItems.add(new Food("Kilo", 1, "Food"));
        allItems.add(new Food("Lima", 1, "Food"));
        allItems.add(new Food("Mango", 1, "Food"));
        allItems.add(new Food("Nitric Acid", 1, "Food"));
        allItems.add(new Food("Oxford", 1, "Food"));
        allItems.add(new Food("Porter John", 1, "Food"));
        allItems.add(new Food("Query", 1, "Food"));
        allItems.add(new Food("Romeo", 1, "Food"));
        return allItems;
    }

    public List<Food> getFruit() {
        List<Food> allItems = new ArrayList<Food>();
        allItems.add(new Food("Alpha", 111, "F"));
        allItems.add(new Food("Beta", 112, "F"));
        allItems.add(new Food("Charlie", 113, "F"));
        allItems.add(new Food("Delta", 114, "F"));
        allItems.add(new Food("Echo", 115, "F"));
        allItems.add(new Food("Foxtrot", 116, "F"));
        allItems.add(new Food("Gamma", 117, "F"));
        allItems.add(new Food("Halo", 118, "F"));
        allItems.add(new Food("Ingrown Hair", 119, "F"));
        allItems.add(new Food("Janky", 120, "F"));
        allItems.add(new Food("Kilo", 121, "F"));
        allItems.add(new Food("Lima", 122, "F"));
        allItems.add(new Food("Mango", 123, "F"));
        allItems.add(new Food("Nitric Acid", 124, "F"));
        allItems.add(new Food("Oxford", 125, "F"));
        allItems.add(new Food("Porter John", 126, "F"));
        allItems.add(new Food("Query", 127, "F"));
        allItems.add(new Food("Romeo", 128, "F"));
        return allItems;
    }

    public List<Food> getVegi() {
        List<Food> allItems = new ArrayList<Food>();
        allItems.add(new Food("Alpha", 131, "V"));
        allItems.add(new Food("Beta", 132, "V"));
        allItems.add(new Food("Charlie", 133, "V"));
        allItems.add(new Food("Delta", 134, "V"));
        allItems.add(new Food("Echo", 135, "V"));
        allItems.add(new Food("Foxtrot", 136, "V"));
        allItems.add(new Food("Gamma", 137, "V"));
        allItems.add(new Food("Halo", 138, "V"));
        allItems.add(new Food("Ingrown Hair", 139, "V"));
        allItems.add(new Food("Janky", 140, "V"));
        allItems.add(new Food("Kilo", 141, "V"));
        allItems.add(new Food("Lima", 142, "V"));
        allItems.add(new Food("Mango", 143, "V"));
        allItems.add(new Food("Nitric Acid", 144, "V"));
        allItems.add(new Food("Oxford", 145, "V"));
        allItems.add(new Food("Porter John", 146, "V"));
        allItems.add(new Food("Query", 147, "V"));
        allItems.add(new Food("Romeo", 148, "V"));
        return allItems;
    }

    public List<Food> getMeat() {
        List<Food> allItems = new ArrayList<Food>();
        allItems.add(new Food("Alpha", 151, "M"));
        allItems.add(new Food("Beta", 152, "M"));
        allItems.add(new Food("Charlie", 153, "M"));
        allItems.add(new Food("Delta", 154, "M"));
        allItems.add(new Food("Echo", 155, "M"));
        allItems.add(new Food("Foxtrot", 156, "M"));
        allItems.add(new Food("Gamma", 157, "M"));
        allItems.add(new Food("Halo", 158, "M"));
        allItems.add(new Food("Ingrown Hair", 159, "M"));
        allItems.add(new Food("Janky", 160, "M"));
        allItems.add(new Food("Kilo", 161, "M"));
        allItems.add(new Food("Lima", 162, "M"));
        allItems.add(new Food("Mango", 163, "M"));
        allItems.add(new Food("Nitric Acid", 164, "M"));
        allItems.add(new Food("Oxford", 165, "M"));
        allItems.add(new Food("Porter John", 166, "M"));
        allItems.add(new Food("Query", 167, "M"));
        allItems.add(new Food("Romeo", 168, "M"));
        return allItems;
    }

    public List<Food> getDairy() {
        List<Food> allItems = new ArrayList<>();
        allItems.add(new Food("Milk", 601, "D"));
        allItems.add(new Food("AMilk", 602, "D"));
        allItems.add(new Food("BMilk", 603, "D"));
        allItems.add(new Food("CMilk", 604, "D"));
        return allItems;
    }

    public List<Food> getGrain() {
        List<Food> allItems = new ArrayList<>();
        allItems.add(new Food("WoodGrain", 701, "G"));
        allItems.add(new Food("GrainGrippin", 702, "G"));
        allItems.add(new Food("inGrain", 703, "G"));
        allItems.add(new Food("GrainMang", 704, "G"));
        return allItems;
    }
}
