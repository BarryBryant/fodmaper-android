package com.b3sk.fodmaper.data;

import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import com.b3sk.fodmaper.helpers.MyApplication;
import com.b3sk.fodmaper.model.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joopk on 4/21/2016.
 */
public class FodmapTask extends AsyncTask<Void, Void, List<Food>> {

    private static final String LOG_TAG = FodmapTask.class.getSimpleName();
    private final foodLoader foodLoader;
    private final Uri uri;
    private final String[] columns;
    private final String key;

    public FodmapTask(foodLoader foodLoader, Uri uri, String[] columns, String key) {
        this.foodLoader = foodLoader;
        this.uri = uri;
        this.columns = columns;
        this.key = key;
    }

    @Override
    protected List<Food> doInBackground(Void... params) {
        Cursor cursor = MyApplication.getAppContext().getContentResolver().query(
                uri,
                columns,
                null,
                null,
                FoodContract.FodmapEntry.COLUMN_FODMAP_NAME + " ASC");
        List<Food> foods = new ArrayList<>();
        while(cursor!= null && cursor.moveToNext()) {
            foods.add(new Food(cursor.getString(1), cursor.getInt(0), cursor.getString(2)));
        }

        if (cursor != null) {
            cursor.close();
        }

        return foods;
    }


    @Override
    protected void onPostExecute(List<Food> foods) {
        foodLoader.onDataLoaded(foods, key);
    }
}
