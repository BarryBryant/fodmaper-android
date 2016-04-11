package com.b3sk.fodmaper.presenter;

import android.support.annotation.NonNull;

import com.b3sk.fodmaper.data.FoodRepository;
import com.b3sk.fodmaper.model.Food;
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
        if (model == null) {
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
        if (meatClicked) {
            meatClicked = false;
            model.removeAll(meat);
            view().onMeatClicked(meatClicked);
            view().animateToFilter(model);
        } else {
            meatClicked = true;
            model.addAll(meat);
            view().onMeatClicked(meatClicked);
            view().animateToFilter(model);
        }
    }
}
