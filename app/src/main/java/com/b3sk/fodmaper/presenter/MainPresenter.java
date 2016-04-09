package com.b3sk.fodmaper.presenter;

import android.support.annotation.NonNull;

import com.b3sk.fodmaper.data.FoodRepository;
import com.b3sk.fodmaper.helpers.FoodFilter;
import com.b3sk.fodmaper.model.FodmapSearch;
import com.b3sk.fodmaper.model.Food;
import com.b3sk.fodmaper.view.FodmapView;
import com.b3sk.fodmaper.view.MainView;

import java.util.List;

/**
 * Created by Joopk on 4/8/2016.
 */
public class MainPresenter extends BasePresenter <List<Food>, MainView> {



    @Override
    public void bindView(@NonNull MainView view) {
        super.bindView(view);
    }

    @Override
    protected void updateView() {}

    public void onCreateMenu(int item) {
        if(item == 1) {
            String query = FodmapSearch.getInstance().getSearch();
            if(query != null) {
                view().createOptionsMenu(true, query, true);
            }else view().createOptionsMenu(true, null, false);
        }else view().createOptionsMenu(false, null, false);
    }

}
