package com.b3sk.fodmaper.helpers;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

/**
 * Created by Joopk on 3/23/2016.
 */
public class MyApplication extends Application {

    private static Context context;

    public static Resources getResourcesStatic(){
        return context.getResources();
    }

    @Override
    public void onCreate(){
        super.onCreate();
        this.context = getApplicationContext();
    }
}
