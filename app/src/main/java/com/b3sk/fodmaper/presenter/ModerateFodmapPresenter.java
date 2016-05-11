package com.b3sk.fodmaper.presenter;

import android.support.annotation.NonNull;

import com.b3sk.fodmaper.data.FodmapTask;
import com.b3sk.fodmaper.data.FoodContract;
import com.b3sk.fodmaper.data.foodLoader;
import com.b3sk.fodmaper.helpers.FoodFilter;
import com.b3sk.fodmaper.model.Food;
import com.b3sk.fodmaper.view.FodmapView;
import com.b3sk.fodmaper.view.ModerateFodmapView;

import java.util.List;

/**
 * Created by Joopk on 4/8/2016.
 */
public class ModerateFodmapPresenter extends BasePresenter <List<Food>, ModerateFodmapView> implements foodLoader {


    @Override
    public void bindView(@NonNull ModerateFodmapView view) {
        super.bindView(view);
        if(model == null) {
            //loadData();
        }
    }

    @Override
    protected void updateView() {
        //view().bindFoods(model);
    }



    private void loadData() {
        String[] columns = {FoodContract.ModerateEntry.COLUMN_MODERATE_NAME,
                FoodContract.ModerateEntry.COLUMN_MODERATE_F,
                FoodContract.ModerateEntry.COLUMN_MODERATE_O,
                FoodContract.ModerateEntry.COLUMN_MODERATE_D,
                FoodContract.ModerateEntry.COLUMN_MODERATE_M,
                FoodContract.ModerateEntry.COLUMN_MODERATE_P};
        FodmapTask task = new FodmapTask(this, FoodContract.ModerateEntry.buildModerateUri(), columns,
                "moderate");
        task.execute();
    }

    @Override
    public void onDataLoaded(List<Food> foods, String key) {
        setModel(foods);
    }
}
