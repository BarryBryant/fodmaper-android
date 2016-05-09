package com.b3sk.fodmaper.presenter;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;

import com.b3sk.fodmaper.data.FodmapTask;
import com.b3sk.fodmaper.data.FoodContract;
import com.b3sk.fodmaper.data.foodLoader;
import com.b3sk.fodmaper.helpers.FoodFilter;
import com.b3sk.fodmaper.helpers.MyApplication;
import com.b3sk.fodmaper.model.Food;
import com.b3sk.fodmaper.view.FodmapView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joopk on 4/8/2016.
 */
public class FodmapPresenter extends BasePresenter<List<Food>, FodmapView> implements foodLoader {


    private String search;

    @Override
    public void bindView(@NonNull FodmapView view) {
        super.bindView(view);
        if (model == null) {
            loadData();
        }
    }

    @Override
    protected void updateView() {
        view().bindFoods(model);

        //If search is not null on resume animate to filtered list
        if (search != null) {
            onQueryTextChanged(search);
        }
    }


    public void onQueryTextChanged(String query) {
        if (model != null) {
            final List<Food> filteredFoodList = FoodFilter.filter(model, query);
            search = query;
            if (view() != null) {
                view().animateToFilter(filteredFoodList);
            }
        }
    }

    private void loadData() {
        String[] columns = {FoodContract.FodmapEntry.COLUMN_FODMAP_ID,
                FoodContract.FodmapEntry.COLUMN_FODMAP_NAME,
                FoodContract.FodmapEntry.COLUMN_FODMAP_INFO};
        FodmapTask task = new FodmapTask(this, FoodContract.FodmapEntry.buildFodmapUri(), columns,
                "fodmap");
        task.execute();
    }

    @Override
    public void onDataLoaded(List<Food> foods, String key) {
        setModel(foods);
    }

}
