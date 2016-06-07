package com.b3sk.fodmaper;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.b3sk.fodmaper.R;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

/**
 * Created by Joopk on 3/23/2016.
 */
public class MyApplication extends Application {

    private static Context context;

    public static Resources getResourcesStatic(){
        return context.getResources();
    }

    public static Context getAppContext() {
        return context;
    }
    private Tracker tracker;

    @Override
    public void onCreate(){
        super.onCreate();
        this.context = getApplicationContext();
    }

    synchronized public Tracker getDefaultTracker() {
        if (tracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            tracker = analytics.newTracker(R.xml.global_tracker);
        }
        return tracker;
    }


}
