package com.b3sk.fodmaper.models;

/**
 * Created by Joopk on 4/3/2016.
 */
public class FodmapSearch {

    private static String mSearch;

    private static FodmapSearch fodmapSearch;

    private FodmapSearch() {
    }

    public static FodmapSearch getInstance() {
        if(fodmapSearch == null) {
            fodmapSearch = new FodmapSearch();
        }
        return fodmapSearch;
    }
    public void setSearch(String s) {
        mSearch = s;
    }

    public String getSearch() {
        return mSearch;
    }

}
