package com.b3sk.fodmaper.model;

/**
 * Created by Joopk on 3/23/2016.
 */
public class Food {

    private String name;
    private int id;
    private String info;

    public Food(String name, int id, String info) {
        this.name = name;
        this.id = id;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
