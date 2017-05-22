package com.b3sk.fodmaper;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import dagger.internal.DaggerCollections;


/**
 * Created by Joopk on 3/23/2016.
 */
public class MyApplication extends Application {

    private static Context context;

    private static int dbVersion = 1;

    public static Resources getResourcesStatic() {
        return getAppContext().getResources();
    }

    public static Context getAppContext() {
        return context;
    }

    private Tracker tracker;
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        component = DaggerAppComponent.builder().appModule(new AppModule(context)).build();
    }

    synchronized public Tracker getDefaultTracker() {
        if (tracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            tracker = analytics.newTracker(R.xml.global_tracker);
        }
        return tracker;
    }

    public AppComponent getComponent() {
        return component;
    }

}
