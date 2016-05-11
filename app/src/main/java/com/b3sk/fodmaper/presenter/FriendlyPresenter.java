package com.b3sk.fodmaper.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.b3sk.fodmaper.data.FodmapTask;
import com.b3sk.fodmaper.data.FoodContract;
import com.b3sk.fodmaper.data.foodLoader;
import com.b3sk.fodmaper.model.Food;
import com.b3sk.fodmaper.view.FriendlyView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joopk on 4/9/2016.
 */
public class FriendlyPresenter extends BasePresenter<List<Food>, FriendlyView> implements foodLoader {

    private static final String LOG_TAG = FriendlyPresenter.class.getSimpleName();
    private boolean fruitClicked = true;
    private boolean vegiClicked = false;
    private boolean proteinClicked = false;
    private boolean otherClicked = false;
    private boolean grainClicked = false;
    private List<Food> fruit;
    private List<Food> vegi;
    private List<Food> protein;
    private List<Food> other;
    private List<Food> grain;



    @Override
    public void bindView(@NonNull FriendlyView view) {
        super.bindView(view);
        if (model == null) {
            loadData();
        }
    }

    @Override
    protected void updateView() {
        view().bindFoods(model);
        view().onFruitClicked(fruitClicked);
        view().onVegiClicked(vegiClicked);
        view().onProteinClicked(proteinClicked);
        view().onOtherClicked(otherClicked);
        view().onGrainClicked(grainClicked);
    }

    private void loadData() {
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

    public void onFruitClicked() {
        if (!fruitClicked) {
            fruitClicked = true;
            vegiClicked = false;
            proteinClicked = false;
            grainClicked = false;
            otherClicked = false;
            model.clear();
            model.addAll(fruit);
            updateViewOnToggle();
        }
    }

    public void onVegiClicked() {
        if (!vegiClicked) {
            fruitClicked = false;
            vegiClicked = true;
            proteinClicked = false;
            grainClicked = false;
            otherClicked = false;
            model.clear();
            model.addAll(vegi);
            updateViewOnToggle();
        }
    }

    public void onProteinClicked() {
        if (!proteinClicked) {
            fruitClicked = false;
            vegiClicked = false;
            proteinClicked = true;
            grainClicked = false;
            otherClicked = false;
            model.clear();
            model.addAll(protein);
            updateViewOnToggle();
        }
    }

    public void onOtherClicked() {
        if (!otherClicked) {
            fruitClicked = false;
            vegiClicked = false;
            proteinClicked = false;
            grainClicked = false;
            otherClicked = true;
            model.clear();
            model.addAll(other);
            updateViewOnToggle();
        }
    }

    public void onGrainClicked() {
        if (!grainClicked) {
            fruitClicked = false;
            vegiClicked = false;
            proteinClicked = false;
            grainClicked = true;
            otherClicked = false;
            model.clear();
            model.addAll(grain);
            updateViewOnToggle();
        }
    }

    private void updateViewOnToggle() {
        view().onFruitClicked(fruitClicked);
        view().onVegiClicked(vegiClicked);
        view().onProteinClicked(proteinClicked);
        view().onOtherClicked(otherClicked);
        view().onGrainClicked(grainClicked);
        view().animateToFilter(model);
    }


    //Chained AsyncTask calls to load each set of fodmap friendly foods from the SQLite database.
    //The sequence is initiated from the loadData() method and subsequent calls are fired off
    //from the onDataLoaded method.
    @Override
    public void onDataLoaded(List<Food> foodList, String key) {
        String[] columns = {FoodContract.ModerateEntry.COLUMN_MODERATE_NAME,
                FoodContract.ModerateEntry.COLUMN_MODERATE_F,
                FoodContract.ModerateEntry.COLUMN_MODERATE_O,
                FoodContract.ModerateEntry.COLUMN_MODERATE_D,
                FoodContract.ModerateEntry.COLUMN_MODERATE_M,
                FoodContract.ModerateEntry.COLUMN_MODERATE_P};

        switch(key) {
            case "fruit": {
                if(foodList != null) {fruit = foodList;}
                FodmapTask vegiTask = new FodmapTask(this,
                        FoodContract.VegiEntry.buildVegiUri(), columns, "vegi");
                vegiTask.execute();
            } break;

            case "vegi": {
                if (foodList != null) {vegi = foodList;}
                FodmapTask proteinTask = new FodmapTask(this,
                        FoodContract.ProteinEntry.buildProteinUri(), columns, "protein");
                proteinTask.execute();
            } break;

            case "protein": {
                if (foodList != null) {protein = foodList;}
                FodmapTask grainTask = new FodmapTask(this,
                        FoodContract.GrainEntry.buildGrainUri(), columns, "grain");
                grainTask.execute();
            } break;

            case "grain": {
                if (foodList != null) {grain = foodList;}
                FodmapTask otherTask = new FodmapTask(this,
                        FoodContract.OtherEntry.buildOtherUri(), columns, "other");
                otherTask.execute();
            } break;

            case "other": {
                if (foodList != null) {other = foodList;}
            }
        }

        //Initialize model based on which button is toggled
        List<Food> modelList = new ArrayList<>();
        if(fruitClicked){
            modelList.addAll(fruit);
            setModel(modelList);
        }else if(vegiClicked){
            modelList.addAll(vegi);
            setModel(modelList);
        }else if(proteinClicked){
            modelList.addAll(protein);
            setModel(modelList);
        }else if(grainClicked){
            modelList.addAll(grain);
            setModel(modelList);
        }else if(otherClicked){
            modelList.addAll(other);
            setModel(modelList);
        }
    }
}
