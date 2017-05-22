package com.b3sk.fodmaper;

import android.content.Context;

import com.b3sk.fodmaper.helpers.FoodGenerator;
import com.b3sk.fodmaper.model.FoodRepo;
import com.b3sk.fodmaper.model.JsonFoodRepoImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Joopkins on 6/19/16.
 */

@Module
public class AppModule {

    private final Context context;

    AppModule(Context context) {
        this.context = context;
    }

    @Provides @Singleton
    public FoodGenerator provideFoodGenerator() {
        FoodGenerator foodGenerator = new FoodGenerator(context);
        return foodGenerator;
    }

    @Provides @Singleton
    public FoodRepo provideFoodRepo(FoodGenerator foodGenerator) {
        FoodRepo foodRepo = new JsonFoodRepoImpl(foodGenerator);
        return foodRepo;
    }
}
