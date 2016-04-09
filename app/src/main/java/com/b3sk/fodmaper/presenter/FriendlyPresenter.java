package com.b3sk.fodmaper.presenter;

import android.support.annotation.NonNull;

import com.b3sk.fodmaper.data.FoodRepository;
import com.b3sk.fodmaper.models.Food;
import com.b3sk.fodmaper.view.FodmapView;
import com.b3sk.fodmaper.view.FriendlyView;

import java.util.List;

/**
 * Created by Joopk on 4/9/2016.
 */
public class FriendlyPresenter extends BasePresenter<List<Food>, FriendlyView> {

    private boolean fruitClicked = true;
    private boolean vegiClicked = true;
    private boolean meatClicked = true;

    @Override
    public void bindView(@NonNull FriendlyView view) {
        super.bindView(view);
        if(model == null) {
            loadData();
        }
    }

    @Override
    protected void updateView() {
        view().bindFoods(model);
        view().onFruitClicked(fruitClicked);
        view().onVegiClicked(vegiClicked);
        view().onMeatClicked(meatClicked);
    }

    private void loadData() {
        setModel(new FoodRepository().getFood());
    }

    public void onFruitClicked() {
        if(fruitClicked) {
            fruitClicked = false;
            view().onFruitClicked(fruitClicked);
        }else {
            fruitClicked = true;
            view().onFruitClicked(fruitClicked);
        }
    }
    
    public void onVegiClicked() {
        if(vegiClicked) {
            vegiClicked = false;
            view().onVegiClicked(vegiClicked);
        }else {
            vegiClicked = true;
            view().onVegiClicked(vegiClicked);
        }
    }

    public void onMeatClicked() {
        if(meatClicked) {
            meatClicked = false;
            view().onMeatClicked(meatClicked);
        }else {
            meatClicked = true;
            view().onMeatClicked(meatClicked);
        }
    }
}
