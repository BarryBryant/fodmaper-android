package com.b3sk.fodmaper.helpers;

/**
 * Created by barrybryant on 5/22/17.
 */

import android.content.Context;

import com.b3sk.fodmaper.model.Food;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Joopkins on 1/1/17.
 */

public class FoodGenerator {

    private Context context;

    public FoodGenerator(Context context) {
        this.context = context;
    }

    public List<Food> generateFoodFromJSON() {
        List<Food> foodList = new ArrayList<>();
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray foodArray = obj.getJSONArray("food");
            for (int i = 0; i < foodArray.length(); i++) {
                JSONObject foodJSON = foodArray.getJSONObject(i);
                Food food = new Food();
                food.setName(foodJSON.getString("name"));
                food.setF(foodJSON.getInt("f"));
                food.setO(foodJSON.getInt("o"));
                food.setD(foodJSON.getInt("d"));
                food.setM(foodJSON.getInt("m"));
                food.setP(foodJSON.getInt("p"));
                foodList.add(food);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return foodList;
    }

    private String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = context.getAssets().open("fodmaps.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
