package com.b3sk.fodmaper.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

import java.io.IOException;

/**
 * Created by Joopk on 4/14/2016.
 */
public class FoodProvider extends ContentProvider {

    private static final UriMatcher uriMatcher = buildUriMatcher();
    private DataBaseHelper openHelper;

    private static final int FODMAPS = 500;

    private static UriMatcher buildUriMatcher() {
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = FoodContract.CONTENT_AUTHORITY;

        uriMatcher.addURI(authority, FoodContract.PATH_FODMAP, FODMAPS);

        return uriMatcher;
    }




    @Override
    public boolean onCreate() {
        Context context = getContext();
        openHelper = new DataBaseHelper(context);
        try {

            openHelper.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        if(uriMatcher.match(uri) == FODMAPS) {
            return openHelper.getReadableDatabase().query(FoodContract.FodmapEntry.TABLE_NAME,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder);
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case FODMAPS:
                return FoodContract.FodmapEntry.CONTENT_TYPE;
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
