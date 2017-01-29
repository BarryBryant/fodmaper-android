package com.b3sk.fodmaper.presenter;

import com.b3sk.fodmaper.view.ModerateFodmapView;

/**
 * Created by Joopkins on 6/18/16.
 */
public interface ModeratePresenter extends LifecyclePresenter<ModerateFodmapView> {
    void loadFood();
}
