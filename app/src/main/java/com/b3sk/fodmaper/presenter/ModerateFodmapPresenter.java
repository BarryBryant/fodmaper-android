package com.b3sk.fodmaper.presenter;

import android.support.annotation.NonNull;

import com.b3sk.fodmaper.model.Food;
import com.b3sk.fodmaper.model.RealmFoodRepoImpl;
import com.b3sk.fodmaper.view.ModerateFodmapView;

import java.util.List;

/**
 * Created by Joopk on 4/8/2016.
 */
public class ModerateFodmapPresenter extends BasePresenter<List<Food>, ModerateFodmapView> {


    @Override
    public void bindView(@NonNull ModerateFodmapView view) {
        super.bindView(view);
        if (model == null) {
            loadData();
        }
    }

    @Override
    protected void updateView() {
        view().bindFoods(model);
    }


    private void loadData() {
        List<Food> foods = new RealmFoodRepoImpl().getModerates();
        if (foods != null) {
            setModel(foods);
        }
    }
}
