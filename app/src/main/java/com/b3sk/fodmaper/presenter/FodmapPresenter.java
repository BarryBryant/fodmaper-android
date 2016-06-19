package com.b3sk.fodmaper.presenter;

import com.b3sk.fodmaper.view.FodmapView;

/**
 * Created by Joopkins on 6/18/16.
 */
public interface FodmapPresenter extends LifecyclePresenter<FodmapView> {

    void onQueryTextChanged(String query);
    void loadFood();

}
