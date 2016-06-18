package com.b3sk.fodmaper;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.b3sk.fodmaper.model.Migration;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Joopk on 3/23/2016.
 */
public class MyApplication extends Application {

    private static Context context;

    public static Resources getResourcesStatic() {
        return context.getResources();
    }

    public static Context getAppContext() {
        return context;
    }

    private Tracker tracker;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        RealmConfiguration config = new RealmConfiguration.Builder(this)
                .name("default.realm")
                .assetFile(this, "default.realm")
                .migration(new Migration())
                .build();
        Realm.setDefaultConfiguration(config);

    }

    synchronized public Tracker getDefaultTracker() {
        if (tracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            tracker = analytics.newTracker(R.xml.global_tracker);
        }
        return tracker;
    }


}
