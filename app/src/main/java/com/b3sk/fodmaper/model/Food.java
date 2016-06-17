package com.b3sk.fodmaper.model;

import android.support.annotation.NonNull;

/**
 * Created by Joopk on 3/23/2016.
 */
public class Food implements Comparable<Food>{

    private String name;
    private int f;
    private int o;
    private int d;
    private int m;
    private int p;

    public Food(String name, int f, int o, int d, int m, int p) {
        this.name = name;

        this.f = f;
        this.o = o;
        this.d = d;
        this.m = m;
        this.p = p;
    }

    public String getName() {
        return name;
    }


    public int getF() {
        return f;
    }

    public int getO() {
        return o;
    }

    public int getD() {
        return d;
    }

    public int getM() {
        return m;
    }

    public int getP() {
        return p;
    }

    public String getInfo() {
        String info = "Contains: ";
        if(f != 1) {
            return "FODMAP Free";
        }else {
            if(o ==1) {info += "Oligosaccharides ";}
            if(d ==1) {info += "Disaccharides ";}
            if(m ==1) {info += "Monosaccharides ";}
            if(p ==1) {info += "Polyols ";}
            return info;
        }
    }

    @Override
    public int compareTo(@NonNull Food food) {
        return name.compareTo(food.getName());
    }

    @Override
    public boolean equals(Object o) {
        return this == o || o instanceof Food && name.equals(((Food) o).getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }


}
