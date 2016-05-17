package com.b3sk.fodmaper.model;

import com.b3sk.fodmaper.data.FodmapTask;
import com.b3sk.fodmaper.data.FoodContract;
import com.b3sk.fodmaper.data.foodLoader;

import java.util.List;


/**
 * Created by Joopkins on 5/14/16.
 */
public class FoodRepository {


    public void getFodmaps(foodLoader foodLoader) {

        String[] columns = {FoodContract.ModerateEntry.COLUMN_MODERATE_NAME,
                FoodContract.ModerateEntry.COLUMN_MODERATE_F,
                FoodContract.ModerateEntry.COLUMN_MODERATE_O,
                FoodContract.ModerateEntry.COLUMN_MODERATE_D,

                FoodContract.ModerateEntry.COLUMN_MODERATE_M,
                FoodContract.ModerateEntry.COLUMN_MODERATE_P};

        FodmapTask task = new FodmapTask(foodLoader, FoodContract.FodmapEntry.buildFodmapUri(), columns,
                "fodmaps");
        task.execute();
    }

    public void getModerates(foodLoader foodLoader) {

        String[] columns = {FoodContract.ModerateEntry.COLUMN_MODERATE_NAME,
                FoodContract.ModerateEntry.COLUMN_MODERATE_F,
                FoodContract.ModerateEntry.COLUMN_MODERATE_O,
                FoodContract.ModerateEntry.COLUMN_MODERATE_D,

                FoodContract.ModerateEntry.COLUMN_MODERATE_M,
                FoodContract.ModerateEntry.COLUMN_MODERATE_P};

        FodmapTask task = new FodmapTask(foodLoader, FoodContract.ModerateEntry.buildModerateUri(), columns,
                "moderates");
        task.execute();
    }

    public void getFruits(foodLoader foodLoader) {

        String[] columns = {FoodContract.ModerateEntry.COLUMN_MODERATE_NAME,
                FoodContract.ModerateEntry.COLUMN_MODERATE_F,
                FoodContract.ModerateEntry.COLUMN_MODERATE_O,
                FoodContract.ModerateEntry.COLUMN_MODERATE_D,

                FoodContract.ModerateEntry.COLUMN_MODERATE_M,
                FoodContract.ModerateEntry.COLUMN_MODERATE_P};

        FodmapTask task = new FodmapTask(foodLoader, FoodContract.FruitEntry.buildFruitUri(), columns,
                "fruit");
        task.execute();
    }

    public void getVeggies(foodLoader foodLoader) {

        String[] columns = {FoodContract.ModerateEntry.COLUMN_MODERATE_NAME,
                FoodContract.ModerateEntry.COLUMN_MODERATE_F,
                FoodContract.ModerateEntry.COLUMN_MODERATE_O,
                FoodContract.ModerateEntry.COLUMN_MODERATE_D,

                FoodContract.ModerateEntry.COLUMN_MODERATE_M,
                FoodContract.ModerateEntry.COLUMN_MODERATE_P};

        FodmapTask task = new FodmapTask(foodLoader, FoodContract.VegiEntry.buildVegiUri(), columns,
                "vegi");
        task.execute();
    }

    public void getProtein(foodLoader foodLoader) {

        String[] columns = {FoodContract.ModerateEntry.COLUMN_MODERATE_NAME,
                FoodContract.ModerateEntry.COLUMN_MODERATE_F,
                FoodContract.ModerateEntry.COLUMN_MODERATE_O,
                FoodContract.ModerateEntry.COLUMN_MODERATE_D,

                FoodContract.ModerateEntry.COLUMN_MODERATE_M,
                FoodContract.ModerateEntry.COLUMN_MODERATE_P};

        FodmapTask task = new FodmapTask(foodLoader, FoodContract.ProteinEntry.buildProteinUri(), columns,
                "protein");
        task.execute();
    }

    public void getGrains(foodLoader foodLoader) {

        String[] columns = {FoodContract.ModerateEntry.COLUMN_MODERATE_NAME,
                FoodContract.ModerateEntry.COLUMN_MODERATE_F,
                FoodContract.ModerateEntry.COLUMN_MODERATE_O,
                FoodContract.ModerateEntry.COLUMN_MODERATE_D,

                FoodContract.ModerateEntry.COLUMN_MODERATE_M,
                FoodContract.ModerateEntry.COLUMN_MODERATE_P};

        FodmapTask task = new FodmapTask(foodLoader, FoodContract.GrainEntry.buildGrainUri(), columns,
                "grain");
        task.execute();
    }

    public void getOthers(foodLoader foodLoader) {

        String[] columns = {FoodContract.ModerateEntry.COLUMN_MODERATE_NAME,
                FoodContract.ModerateEntry.COLUMN_MODERATE_F,
                FoodContract.ModerateEntry.COLUMN_MODERATE_O,
                FoodContract.ModerateEntry.COLUMN_MODERATE_D,

                FoodContract.ModerateEntry.COLUMN_MODERATE_M,
                FoodContract.ModerateEntry.COLUMN_MODERATE_P};

        FodmapTask task = new FodmapTask(foodLoader, FoodContract.OtherEntry.buildOtherUri(), columns,
                "other");
        task.execute();
    }



}
