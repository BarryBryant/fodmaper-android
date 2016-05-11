package com.b3sk.fodmaper.model;

/**
 * Created by Joopk on 3/23/2016.
 */
public class Food {

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
}
