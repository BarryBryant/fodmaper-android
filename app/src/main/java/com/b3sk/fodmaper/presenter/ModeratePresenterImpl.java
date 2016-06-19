package com.b3sk.fodmaper.presenter;

import android.support.annotation.NonNull;

import com.b3sk.fodmaper.model.Food;
import com.b3sk.fodmaper.model.FoodRepo;
import com.b3sk.fodmaper.view.ModerateFodmapView;

import java.util.List;

/**
 * Created by Joopkins on 6/18/16.
 */
public class ModeratePresenterImpl implements ModeratePresenter {

    private FoodRepo repo;
    private List<Food> model;
    private ModerateFodmapView view;

    public ModeratePresenterImpl(FoodRepo repo) {
        this.repo = repo;
    }

    @Override
    public void bindView(@NonNull ModerateFodmapView view) {
        this.view = view;
        loadFood();
    }

    @Override
    public void unbindView() {
        this.view = null;
    }

    @Override
    public void loadFood() {
        if (model == null) {
            model = repo.getModerates();
        }
        view.bindFoods(model);
    }
}
