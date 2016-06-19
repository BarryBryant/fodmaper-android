package com.b3sk.fodmaper.presenter;

import android.support.annotation.NonNull;

import com.b3sk.fodmaper.model.FoodRepo;
import com.b3sk.fodmaper.view.FriendlyView;

/**
 * Created by Joopkins on 6/18/16.
 */
public class FriendlyPresenterImpl implements FriendlyPresenter {

    private FriendlyView view;
    private FoodRepo repo;
    private int listToggled = 0;

    public FriendlyPresenterImpl(FoodRepo repo) {
        this.repo = repo;
    }


    @Override
    public void bindView(@NonNull FriendlyView view) {
        this.view = view;
        loadFood();
    }

    @Override
    public void unbindView() {
        this.view = null;
    }

    @Override
    public void loadFood() {

        switch (listToggled) {
            case 0:
                view.bindFoods(repo.getFruits());
                break;
            case 1:
                view.bindFoods(repo.getVeggies());
                break;
            case 2:
                view.bindFoods(repo.getProtein());
                break;
            case 3:
                view.bindFoods(repo.getGrains());
                break;
            case 4:
                view.bindFoods(repo.getOthers());
                break;
        }

        updateToggles();
    }

    @Override
    public void onFruitClicked() {
        if (listToggled != 0) {
            listToggled = 0;
            view.animateToFilter(repo.getFruits());
            updateToggles();
        }
    }

    @Override
    public void onVegiClicked() {
        if (listToggled != 1) {
            listToggled = 1;
            view.animateToFilter(repo.getVeggies());
            updateToggles();
        }
    }

    @Override
    public void onProteinClicked() {
        if (listToggled != 2) {
            listToggled = 2;
            view.animateToFilter(repo.getProtein());
            updateToggles();
        }
    }

    @Override
    public void onGrainClicked() {
        if (listToggled != 3) {
            listToggled = 3;
            view.animateToFilter(repo.getGrains());
            updateToggles();
        }
    }

    @Override
    public void onOtherClicked() {
        if (listToggled != 4) {
            listToggled = 4;
            view.animateToFilter(repo.getOthers());
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
