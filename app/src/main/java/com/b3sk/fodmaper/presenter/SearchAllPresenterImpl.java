package com.b3sk.fodmaper.presenter;

import android.support.annotation.NonNull;

import com.b3sk.fodmaper.helpers.FoodFilter;
import com.b3sk.fodmaper.model.Food;
import com.b3sk.fodmaper.model.FoodRepo;
import com.b3sk.fodmaper.view.FodmapView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Joopkins on 6/18/16.
 */
public class SearchAllPresenterImpl implements FodmapPresenter {

    private FoodRepo repo;
    private List<Food> model = new ArrayList<>();
    private FodmapView view;
    private String search;

    public SearchAllPresenterImpl(FoodRepo repo) {
        this.repo = repo;
    }


    @Override
    public void loadFood() {
        model.addAll(repo.getAllFood());
        view.bindFoods(model);
        if (search != null && search.length() > 0) {
            onQueryTextChanged(search);
        }

    }

    @Override
    public void bindView(@NonNull FodmapView view) {
        this.view = view;
        loadFood();
    }

    @Override
    public void unbindView() {
        this.view = null;
    }

    @Override
    public void onQueryTextChanged(String query) {
        if (model != null) {
            final List<Food> filteredFoodList = FoodFilter.filter(model, query);
            search = query;
            if (view != null) {
                view.animateToFilter(filteredFoodList);
            }
        }
    }
}
