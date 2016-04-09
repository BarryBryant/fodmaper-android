package com.b3sk.fodmaper.presenter;

import android.support.annotation.NonNull;

import com.b3sk.fodmaper.data.FoodRepository;
import com.b3sk.fodmaper.helpers.FoodFilter;
import com.b3sk.fodmaper.model.FodmapSearch;
import com.b3sk.fodmaper.model.Food;
import com.b3sk.fodmaper.view.FodmapView;

import java.util.List;

/**
 * Created by Joopk on 4/8/2016.
 */
public class FodmapPresenter extends BasePresenter <List<Food>, FodmapView> {



    @Override
    public void bindView(@NonNull FodmapView view) {
        super.bindView(view);
        if(model == null) {
            loadData();
        }
    }

    @Override
    protected void updateView() {
        view().bindFoods(model);

        //If search is not null on resume animate to filtered list
        String query = FodmapSearch.getInstance().getSearch();
        if(query != null) {
            onQueryTextChanged(query);
        }
    }


    public void onQueryTextChanged(String query) {
        final List<Food> filteredFoodList = FoodFilter.filter(model, query);
        FodmapSearch.getInstance().setSearch(query);
        view().animateToFilter(filteredFoodList);
    }

    private void loadData() {
        setModel(new FoodRepository().getFood());
    }
}
