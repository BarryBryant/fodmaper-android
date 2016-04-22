package com.b3sk.fodmaper.data;

import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Log;

import com.b3sk.fodmaper.helpers.MyApplication;
import com.b3sk.fodmaper.model.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joopk on 4/21/2016.
 */
public class FodmapTask extends AsyncTask<Void, Void, List<Food>> {

    private static final String LOG_TAG = FodmapTask.class.getSimpleName();
    private final com.b3sk.fodmaper.presenter.FodmapPresenter fodmapPresenter;

    public FodmapTask(com.b3sk.fodmaper.presenter.FodmapPresenter fodmapPresenter) {
        this.fodmapPresenter = fodmapPresenter;
    }

    @Override
    protected List<Food> doInBackground(Void... params) {
        String[] COLUMNS = {FoodContract.FodmapEntry.COLUMN_FODMAP_ID,
                FoodContract.FodmapEntry.COLUMN_FODMAP_NAME,
                FoodContract.FodmapEntry.COLUMN_FODMAP_INFO};
        Cursor cursor = MyApplication.getAppContext().getContentResolver().query(
                FoodContract.FodmapEntry.buildFodmapUri(),
                COLUMNS,
                null,
                null,
                FoodContract.FodmapEntry.COLUMN_FODMAP_NAME + " ASC");
        List<Food> foods = new ArrayList<>();
        while(cursor!= null && cursor.moveToNext()) {
            foods.add(new Food(cursor.getString(1), cursor.getInt(0), cursor.getString(2)));
        }

        return foods;
    }


    @Override
    protected void onPostExecute(List<Food> foods) {
        fodmapPresenter.onDataLoaded(foods);
    }
}
