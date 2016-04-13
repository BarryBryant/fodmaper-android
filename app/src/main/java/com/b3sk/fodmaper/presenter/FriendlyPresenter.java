package com.b3sk.fodmaper.presenter;

import android.support.annotation.NonNull;

import com.b3sk.fodmaper.data.FoodRepository;
import com.b3sk.fodmaper.model.Food;
import com.b3sk.fodmaper.view.FriendlyView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joopk on 4/9/2016.
 */
public class FriendlyPresenter extends BasePresenter<List<Food>, FriendlyView> {

    private boolean fruitClicked = true;
    private boolean vegiClicked = true;
    private boolean meatClicked = true;
    private boolean dairyClicked = true;
    private boolean grainClicked = true;
    private List<Food> fruit;
    private List<Food> vegi;
    private List<Food> meat;
    private List<Food> dairy;
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
        view().onMeatClicked(meatClicked);
        view().onDairyClicked(dairyClicked);
        view().onGrainClicked(grainClicked);
    }

    private void loadData() {
        List<Food> data = new ArrayList<>();
        FoodRepository dataBoy = new FoodRepository();
        fruit = dataBoy.getFruit();
        vegi = dataBoy.getVegi();
        meat = dataBoy.getMeat();
        dairy = dataBoy.getDairy();
        grain = dataBoy.getGrain();
        if(fruitClicked) {data.addAll(fruit);}
        if(vegiClicked) {data.addAll(vegi);}
        if(meatClicked) {data.addAll(meat);}
        if(dairyClicked) {data.addAll(dairy);}
        if(grainClicked) {data.addAll(grain);}
        setModel(data);
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

    public void onDairyClicked() {
        if (dairyClicked) {
            dairyClicked = false;
            model.removeAll(dairy);
            view().onDairyClicked(dairyClicked);
            view().animateToFilter(model);
        } else {
            dairyClicked = true;
            model.addAll(dairy);
            view().onDairyClicked(dairyClicked);
            view().animateToFilter(model);
        }
    }

    public void onGrainClicked() {
        if (grainClicked) {
            grainClicked = false;
            model.removeAll(grain);
            view().onGrainClicked(grainClicked);
            view().animateToFilter(model);
        } else {
            grainClicked = true;
            model.addAll(grain);
            view().onGrainClicked(grainClicked);
            view().animateToFilter(model);
        }
    }
}
