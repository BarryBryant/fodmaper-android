package com.b3sk.fodmaper.model;

import com.b3sk.fodmaper.data.FodmapTask;
import com.b3sk.fodmaper.data.FoodContract;
import com.b3sk.fodmaper.data.foodLoader;

import java.util.List;


/**
 * Created by Joopkins on 5/14/16.
 */
public class FoodRepository implements foodLoader {

    private foodLoader presenterFoodLoader;

    public void getFodmaps(foodLoader foodLoader) {
        presenterFoodLoader = foodLoader;

        String[] columns = {FoodContract.ModerateEntry.COLUMN_MODERATE_NAME,
                FoodContract.ModerateEntry.COLUMN_MODERATE_F,
                FoodContract.ModerateEntry.COLUMN_MODERATE_O,
                FoodContract.ModerateEntry.COLUMN_MODERATE_D,

                FoodContract.ModerateEntry.COLUMN_MODERATE_M,
                FoodContract.ModerateEntry.COLUMN_MODERATE_P};

        FodmapTask task = new FodmapTask(this, FoodContract.FodmapEntry.buildFodmapUri(), columns,
                "fodmaps");
        task.execute();
    }

    public void getModerates(foodLoader foodLoader) {
        presenterFoodLoader = foodLoader;

        String[] columns = {FoodContract.ModerateEntry.COLUMN_MODERATE_NAME,
                FoodContract.ModerateEntry.COLUMN_MODERATE_F,
                FoodContract.ModerateEntry.COLUMN_MODERATE_O,
                FoodContract.ModerateEntry.COLUMN_MODERATE_D,

                FoodContract.ModerateEntry.COLUMN_MODERATE_M,
                FoodContract.ModerateEntry.COLUMN_MODERATE_P};

        FodmapTask task = new FodmapTask(this, FoodContract.ModerateEntry.buildModerateUri(), columns,
                "moderates");
        task.execute();
    }

    public void getFruits(foodLoader foodLoader) {
        presenterFoodLoader = foodLoader;

        String[] columns = {FoodContract.ModerateEntry.COLUMN_MODERATE_NAME,
                FoodContract.ModerateEntry.COLUMN_MODERATE_F,
                FoodContract.ModerateEntry.COLUMN_MODERATE_O,
                FoodContract.ModerateEntry.COLUMN_MODERATE_D,

                FoodContract.ModerateEntry.COLUMN_MODERATE_M,
                FoodContract.ModerateEntry.COLUMN_MODERATE_P};

        FodmapTask task = new FodmapTask(this, FoodContract.FruitEntry.buildFruitUri(), columns,
                "fruit");
        task.execute();
    }

    public void getVeggies(foodLoader foodLoader) {
        presenterFoodLoader = foodLoader;

        String[] columns = {FoodContract.ModerateEntry.COLUMN_MODERATE_NAME,
                FoodContract.ModerateEntry.COLUMN_MODERATE_F,
                FoodContract.ModerateEntry.COLUMN_MODERATE_O,
                FoodContract.ModerateEntry.COLUMN_MODERATE_D,

                FoodContract.ModerateEntry.COLUMN_MODERATE_M,
                FoodContract.ModerateEntry.COLUMN_MODERATE_P};

        FodmapTask task = new FodmapTask(this, FoodContract.VegiEntry.buildVegiUri(), columns,
                "vegi");
        task.execute();
    }

    public void getProtein(foodLoader foodLoader) {
        presenterFoodLoader = foodLoader;

        String[] columns = {FoodContract.ModerateEntry.COLUMN_MODERATE_NAME,
                FoodContract.ModerateEntry.COLUMN_MODERATE_F,
                FoodContract.ModerateEntry.COLUMN_MODERATE_O,
                FoodContract.ModerateEntry.COLUMN_MODERATE_D,

                FoodContract.ModerateEntry.COLUMN_MODERATE_M,
                FoodContract.ModerateEntry.COLUMN_MODERATE_P};

        FodmapTask task = new FodmapTask(this, FoodContract.ProteinEntry.buildProteinUri(), columns,
                "protein");
        task.execute();
    }

    public void getGrains(foodLoader foodLoader) {
        presenterFoodLoader = foodLoader;

        String[] columns = {FoodContract.ModerateEntry.COLUMN_MODERATE_NAME,
                FoodContract.ModerateEntry.COLUMN_MODERATE_F,
                FoodContract.ModerateEntry.COLUMN_MODERATE_O,
                FoodContract.ModerateEntry.COLUMN_MODERATE_D,

                FoodContract.ModerateEntry.COLUMN_MODERATE_M,
                FoodContract.ModerateEntry.COLUMN_MODERATE_P};

        FodmapTask task = new FodmapTask(this, FoodContract.GrainEntry.buildGrainUri(), columns,
                "grain");
        task.execute();
    }

    public void getOthers(foodLoader foodLoader) {
        presenterFoodLoader = foodLoader;

        String[] columns = {FoodContract.ModerateEntry.COLUMN_MODERATE_NAME,
                FoodContract.ModerateEntry.COLUMN_MODERATE_F,
                FoodContract.ModerateEntry.COLUMN_MODERATE_O,
                FoodContract.ModerateEntry.COLUMN_MODERATE_D,

                FoodContract.ModerateEntry.COLUMN_MODERATE_M,
                FoodContract.ModerateEntry.COLUMN_MODERATE_P};

        FodmapTask task = new FodmapTask(this, FoodContract.OtherEntry.buildOtherUri(), columns,
                "other");
        task.execute();
    }


    @Override
    public void onDataLoaded(List<Food> foodList, String key) {
        presenterFoodLoader.onDataLoaded(foodList, key);
    }
}
