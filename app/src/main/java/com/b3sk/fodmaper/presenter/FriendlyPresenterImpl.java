package com.b3sk.fodmaper.presenter;

import android.support.annotation.NonNull;

import com.b3sk.fodmaper.model.Food;
import com.b3sk.fodmaper.model.FoodRepo;
import com.b3sk.fodmaper.view.FriendlyView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joopkins on 6/18/16.
 */
public class FriendlyPresenterImpl implements LifecyclePresenter<FriendlyView>, FriendlyPresenter {

    private List<Food> fruit;
    private List<Food> vegi;
    private List<Food> protein;
    private List<Food> other;
    private List<Food> grain;
    private FriendlyView view;
    private List<Food> model;
    private FoodRepo repo;
    private int listToggled = 0;

    public FriendlyPresenterImpl(FoodRepo repo) {
        this.repo = repo;
    }


    @Override
    public void bindView(@NonNull FriendlyView view) {
        this.view = view;
    }

    @Override
    public void unbindView() {
        this.view = null;
    }

    @Override
    public void loadFood() {
        fruit = repo.getFruits();
        vegi = repo.getVeggies();
        protein = repo.getProtein();
        grain = repo.getGrains();
        other = repo.getOthers();

        List<Food> modelList = new ArrayList<>();

        switch (listToggled) {
            case 0: modelList.addAll(fruit);
                break;
            case 1: modelList.addAll(vegi);
                break;
            case 2: modelList.addAll(protein);
                break;
            case 3: modelList.addAll(grain);
                break;
            case 4: modelList.addAll(other);
                break;
        }

        model = modelList;
        view.bindFoods(model);

        updateToggles();
    }

    @Override
    public void onFruitClicked() {
        if (listToggled != 0) {
            listToggled = 0;
            model.clear();
            model.addAll(fruit);
            view.animateToFilter(model);
            updateToggles();
        }
    }

    @Override
    public void onVegiClicked() {
        if (listToggled != 1) {
            listToggled = 1;
            model.clear();
            model.addAll(vegi);
            view.animateToFilter(model);
            updateToggles();
        }
    }

    @Override
    public void onProteinClicked() {
        if (listToggled != 2) {
            listToggled = 2;
            model.clear();
            model.addAll(protein);
            view.animateToFilter(model);
            updateToggles();
        }
    }

    @Override
    public void onGrainClicked() {
        if (listToggled != 3) {
            listToggled = 3;
            model.clear();
            model.addAll(grain);
            view.animateToFilter(model);
            updateToggles();
        }
    }

    @Override
    public void onOtherClicked() {
        if (listToggled != 4) {
            listToggled = 4;
            model.clear();
            model.addAll(other);
            view.animateToFilter(model);
            updateToggles();
        }
    }

    private void updateToggles() {
        view.onFruitClicked(listToggled == 0);
        view.onVegiClicked(listToggled == 1);
        view.onProteinClicked(listToggled == 2);
        view.onGrainClicked(listToggled == 3);
        view.onOtherClicked(listToggled == 4);
    }
}
