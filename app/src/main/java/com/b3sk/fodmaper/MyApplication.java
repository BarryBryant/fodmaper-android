package com.b3sk.fodmaper;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.b3sk.fodmaper.helpers.PrefManager;
import com.b3sk.fodmaper.helpers.RealmGenerator;
import com.b3sk.fodmaper.model.Food;
import com.b3sk.fodmaper.model.Migration;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Joopk on 3/23/2016.
 */
public class MyApplication extends Application {

    private static Context context;

    private static int dbVersion = 0;

    public static Resources getResourcesStatic() {
        return context.getResources();
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
        component = DaggerAppComponent.builder().build();
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(realmConfiguration);
        initDb();
    }

    private void initDb() {
        PrefManager manager = new PrefManager(context);
        if (!manager.isDbInit()) {
            Realm.deleteRealm(new RealmConfiguration.Builder().build());
        }
        if (!manager.isDbInit() || manager.getDbVersion() != dbVersion) {
            RealmGenerator generator = new RealmGenerator(context);
            generator.copyJsonAssetToRealm();
            manager.setDbInit(true);
            manager.setDbVersion(dbVersion);
        }
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
