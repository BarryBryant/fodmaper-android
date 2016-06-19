package com.b3sk.fodmaper;

import android.app.Application;

import com.b3sk.fodmaper.model.FoodRepo;
import com.b3sk.fodmaper.model.RealmFoodRepoImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Joopkins on 6/19/16.
 */

@Module
public class AppModule {
    @Provides @Singleton
    public FoodRepo provideFoodRepo() {
        return new RealmFoodRepoImpl();
    }
}
