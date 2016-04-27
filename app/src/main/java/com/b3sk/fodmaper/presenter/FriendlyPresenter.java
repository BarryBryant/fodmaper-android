package com.b3sk.fodmaper.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.b3sk.fodmaper.data.FodmapTask;
import com.b3sk.fodmaper.data.FoodContract;
import com.b3sk.fodmaper.data.FoodRepository;
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
    private boolean vegiClicked = true;
    private boolean proteinClicked = true;
    private boolean otherClicked = true;
    private boolean grainClicked = true;
    private List<Food> fruit;
    private List<Food> vegi;
    private List<Food> protein;
    private List<Food> other;
    private List<Food> grain;
    private List<Food> data;


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
        view().onMeatClicked(proteinClicked);
        view().onDairyClicked(otherClicked);
        view().onGrainClicked(grainClicked);
    }

    private void loadData() {
        data = new ArrayList<>();
        String[] columns = {FoodContract.FodmapEntry.COLUMN_FODMAP_ID,
                FoodContract.FodmapEntry.COLUMN_FODMAP_NAME,
                FoodContract.FodmapEntry.COLUMN_FODMAP_INFO};

        FodmapTask task = new FodmapTask(this, FoodContract.FruitEntry.buildFruitUri(), columns,
                "fruit");
        task.execute();


    }

    public void onFruitClicked() {
        if (fruitClicked) {
            fruitClicked = false;
            model.removeAll(fruit);
            view().onFruitClicked(fruitClicked);
            view().animateToFilter(model);
        } else {
            fruitClicked = true;
            model.addAll(fruit);
            view().onFruitClicked(fruitClicked);
            view().animateToFilter(model);
        }
    }

    public void onVegiClicked() {
        if (vegiClicked) {
            vegiClicked = false;
            model.removeAll(vegi);
            view().onVegiClicked(vegiClicked);
            view().animateToFilter(model);
        } else {
            vegiClicked = true;
            model.addAll(vegi);
            view().onVegiClicked(vegiClicked);
            view().animateToFilter(model);
        }
    }

    public void onMeatClicked() {
        if (proteinClicked) {
            proteinClicked = false;
            model.removeAll(protein);
            view().onMeatClicked(proteinClicked);
            view().animateToFilter(model);
        } else {
            proteinClicked = true;
            model.addAll(protein);
            view().onMeatClicked(proteinClicked);
            view().animateToFilter(model);
        }
    }

    public void onDairyClicked() {
        if (otherClicked) {
            otherClicked = false;
            model.removeAll(other);
            view().onDairyClicked(otherClicked);
            view().animateToFilter(model);
        } else {
            otherClicked = true;
            model.addAll(other);
            view().onDairyClicked(otherClicked);
            view().animateToFilter(model);
        }
    }

    public void onGrainClicked() {
        if (grainClicked) {
            grainClicked = false;
            model.removeAll(grain);
            view().onGrainClicked(grainClicked);
            view().animateToFilter(model);
        } else {
            grainClicked = true;
            model.addAll(grain);
            view().onGrainClicked(grainClicked);
            view().animateToFilter(model);
        }
    }


    //Chained AsyncTask calls to load each set of fodmap friendly foods from the SQLite database.
    //The sequence is initiated from the loadData() method and subsequent calls are fired off
    //from the onDataLoaded method.
    @Override
    public void onDataLoaded(List<Food> foodList, String key) {
        String[] columns = {FoodContract.FodmapEntry.COLUMN_FODMAP_ID,
                FoodContract.FodmapEntry.COLUMN_FODMAP_NAME,
                FoodContract.FodmapEntry.COLUMN_FODMAP_INFO};

        switch(key) {
            case "fruit": {
                if(foodList != null) {
                    fruit = foodList;
                    if(fruitClicked) {data.addAll(fruit);}
                }
                FodmapTask vegiTask = new FodmapTask(this, FoodContract.VegiEntry.buildVegiUri(), columns,
                        "vegi");
                vegiTask.execute();
            } break;

            case "vegi": {
                if (foodList != null) {
                    vegi = foodList;
                    if (vegiClicked) {
                        data.addAll(vegi);
                    }
                }
                FodmapTask proteinTask = new FodmapTask(this, FoodContract.ProteinEntry.buildProteinUri(), columns,
                        "protein");
                proteinTask.execute();
            } break;

            case "protein": {
                if (foodList != null) {
                    protein = foodList;
                    if (proteinClicked) {
                        data.addAll(protein);
                    }
                }
                FodmapTask grainTask = new FodmapTask(this, FoodContract.GrainEntry.buildGrainUri(), columns,
                        "grain");
                grainTask.execute();
            } break;

            case "grain": {
                if (foodList != null) {
                    grain = foodList;
                    if (grainClicked) {
                        data.addAll(grain);
                    }
                }
                FodmapTask otherTask = new FodmapTask(this, FoodContract.OtherEntry.buildOtherUri(), columns,
                        "other");
                otherTask.execute();
            } break;

            case "other": {
                if (foodList != null) {
                    other = foodList;
                    if (otherClicked) {
                        data.addAll(other);
                    }
                }
                setModel(data);
            }

        }

    }
}
