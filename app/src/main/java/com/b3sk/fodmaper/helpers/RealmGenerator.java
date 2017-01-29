package com.b3sk.fodmaper.helpers;

import android.content.Context;

import com.b3sk.fodmaper.model.Food;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import io.realm.Realm;

/**
 * Created by Joopkins on 1/1/17.
 */

public class RealmGenerator {

    private Context context;

    public RealmGenerator(Context context) {
        this.context = context;
    }

    public void copyJsonAssetToRealm() {
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray foodArray = obj.getJSONArray("food");
            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            for (int i = 0; i < foodArray.length(); i++) {
                JSONObject food = foodArray.getJSONObject(i);
                Food realmFood = new Food();
                realmFood.setName(food.getString("name"));
                realmFood.setF(food.getInt("f"));
                realmFood.setO(food.getInt("o"));
                realmFood.setD(food.getInt("d"));
                realmFood.setM(food.getInt("m"));
                realmFood.setP(food.getInt("p"));
                realm.copyToRealmOrUpdate(realmFood);

            }
            realm.commitTransaction();
        } catch (JSONException e) {
            e.printStackTrace();
        }
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
