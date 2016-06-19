package com.b3sk.fodmaper.presenter;

import android.support.annotation.NonNull;

/**
 * Created by Joopkins on 6/18/16.
 */
public interface LifecyclePresenter<V> {
    void bindView(@NonNull V view);
    void unbindView();
}
