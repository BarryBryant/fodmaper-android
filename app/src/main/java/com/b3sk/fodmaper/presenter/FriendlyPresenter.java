package com.b3sk.fodmaper.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.b3sk.fodmaper.data.FodmapTask;
import com.b3sk.fodmaper.data.FoodContract;
import com.b3sk.fodmaper.data.foodLoader;
import com.b3sk.fodmaper.model.Food;
import com.b3sk.fodmaper.model.FoodRepository;
import com.b3sk.fodmaper.view.FriendlyView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joopk on 4/9/2016.
 */
public class FriendlyPresenter extends BasePresenter<List<Food>, FriendlyView> implements foodLoader {

    private boolean fruitClicked = true;
    private boolean vegiClicked = false;
    private boolean proteinClicked = false;
    private boolean otherClicked = false;
    private boolean grainClicked = false;

    private boolean fruitLoaded = false;
    private boolean vegiLoaded = false;
    private boolean proteinLoaded = false;
    private boolean grainLoaded = false;
    private boolean otherLoaded = false;


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
        FoodRepository foodRepository = new FoodRepository();
        foodRepository.getFruits(this);
        foodRepository.getVeggies(this);
        foodRepository.getProtein(this);
        foodRepository.getGrains(this);
        foodRepository.getOthers(this);


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



    @Override
    public void onDataLoaded(List<Food> foodList, String key) {

        switch(key) {
            case "fruit":
                if(foodList != null) {
                    fruit = foodList;
                    fruitLoaded = true;
                }
                break;

            case "vegi":
                if (foodList != null) {
                    vegi = foodList;
                    vegiLoaded = true;
                }
                break;

            case "protein":
                if (foodList != null) {
                    protein = foodList;
                    proteinLoaded = true;
                }
                break;

            case "grain":
                if (foodList != null) {
                    grain = foodList;
                    grainLoaded = true;
                }
             break;

            case "other":
                if (foodList != null) {
                    other = foodList;
                    otherLoaded = true;
                }

        }

        if(fruitLoaded & vegiLoaded & proteinLoaded & grainLoaded & otherLoaded) {
            initializeModel();
        }

    }

    private void initializeModel() {

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
