package com.b3sk.fodmaper.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;

/**
 * Created by Joopkins on 6/18/16.
 */
public class RealmFoodRepoImpl implements FoodRepo {
    @Override
    public List<Food> getFodmaps() {
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<Food> query = realm.where(Food.class);
        query.equalTo("f", 2);
        List<Food> foods = new ArrayList<>();
        foods.addAll(query.findAll());
        Collections.sort(foods);
        return foods;
    }

    @Override
    public List<Food> getModerates() {
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<Food> query = realm.where(Food.class);
        query.equalTo("f", 1);
        List<Food> foods = new ArrayList<>();
        foods.addAll(query.findAll());
        Collections.sort(foods);
        return foods;
    }

    @Override
    public List<Food> getFruits() {
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<Food> query = realm.where(Food.class);
        query.equalTo("f", -1);
        List<Food> foods = new ArrayList<>();
        foods.addAll(query.findAll());
        Collections.sort(foods);
        return foods;
    }

    @Override
    public List<Food> getVeggies() {
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<Food> query = realm.where(Food.class);
        query.equalTo("f", -2);
        List<Food> foods = new ArrayList<>();
        foods.addAll(query.findAll());
        Collections.sort(foods);
        return foods;
    }

    @Override
    public List<Food> getProtein() {
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<Food> query = realm.where(Food.class);
        query.equalTo("f", -3);
        List<Food> foods = new ArrayList<>();
        foods.addAll(query.findAll());
        Collections.sort(foods);
        return foods;
    }

    @Override
    public List<Food> getGrains() {
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<Food> query = realm.where(Food.class);
        query.equalTo("f", -4);
        List<Food> foods = new ArrayList<>();
        foods.addAll(query.findAll());
        Collections.sort(foods);
        return foods;
    }

    @Override
    public List<Food> getOthers() {
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<Food> query = realm.where(Food.class);
        query.equalTo("f", -5);
        List<Food> foods = new ArrayList<>();
        foods.addAll(query.findAll());
        Collections.sort(foods);
        return foods;
    }

    @Override
    public List<Food> getAllFood() {
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<Food> query = realm.where(Food.class);
        List<Food> foods = new ArrayList<>();
        foods.addAll(query.findAll());
        Collections.sort(foods);
        return foods;
    }
}
