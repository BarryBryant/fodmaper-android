package com.b3sk.fodmaper.presenter;

import com.b3sk.fodmaper.view.FriendlyView;

/**
 * Created by Joopkins on 6/18/16.
 */
public interface FriendlyPresenter extends LifecyclePresenter<FriendlyView> {

    void loadFood();
    void onFruitClicked();
    void onVegiClicked();
    void onProteinClicked();
    void onGrainClicked();
    void onOtherClicked();
}
