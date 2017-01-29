package com.b3sk.fodmaper.helpers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Joopkins on 5/13/16.
 */
public class PrefManager {
    // Shared preferences file name
    private static final String PREF_NAME = "androidhive-welcome";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String IS_DB_INIT = "IsDbInit";
    private static final String DB_VERSION = "dbVersion";

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    // shared pref mode
    int PRIVATE_MODE = 0;

    public PrefManager(Context context) {
        this.context = context;
        pref = this.context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isDbInit() {
        return pref.getBoolean(IS_DB_INIT, false);
    }

    public void setDbInit(boolean init) {
        editor.putBoolean(IS_DB_INIT, init);
        editor.commit();
    }

    public int getDbVersion() {
        return pref.getInt(DB_VERSION, -1);
    }

    public void setDbVersion(int version) {
        editor.putInt(DB_VERSION, version);
        editor.commit();
    }
}
