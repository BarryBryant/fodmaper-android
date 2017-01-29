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
    private static final int FRUIT = 101;
    private static final int VEGI = 102;
    private static final int PROTEIN = 103;
    private static final int GRAIN = 104;
    private static final int OTHER = 105;
    private static final int MODERATE = 106;


    private static UriMatcher buildUriMatcher() {
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = FoodContract.CONTENT_AUTHORITY;

        uriMatcher.addURI(authority, FoodContract.PATH_FODMAP, FODMAPS);
        uriMatcher.addURI(authority, FoodContract.PATH_FRUIT, FRUIT);
        uriMatcher.addURI(authority, FoodContract.PATH_VEGI, VEGI);
        uriMatcher.addURI(authority, FoodContract.PATH_PROTEIN, PROTEIN);
        uriMatcher.addURI(authority, FoodContract.PATH_GRAIN, GRAIN);
        uriMatcher.addURI(authority, FoodContract.PATH_OTHER, OTHER);
        uriMatcher.addURI(authority, FoodContract.PATH_MODERATE, MODERATE);

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

        if(uriMatcher.match(uri) == FRUIT) {
            return openHelper.getReadableDatabase().query(FoodContract.FruitEntry.TABLE_NAME,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder);
        }

        if(uriMatcher.match(uri) == VEGI) {
            return openHelper.getReadableDatabase().query(FoodContract.VegiEntry.TABLE_NAME,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder);
        }

        if(uriMatcher.match(uri) == PROTEIN) {
            return openHelper.getReadableDatabase().query(FoodContract.ProteinEntry.TABLE_NAME,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder);
        }

        if(uriMatcher.match(uri) == GRAIN) {
            return openHelper.getReadableDatabase().query(FoodContract.GrainEntry.TABLE_NAME,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder);
        }

        if(uriMatcher.match(uri) == OTHER) {
            return openHelper.getReadableDatabase().query(FoodContract.OtherEntry.TABLE_NAME,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder);
        }

        if(uriMatcher.match(uri) == MODERATE) {
            return openHelper.getReadableDatabase().query(FoodContract.ModerateEntry.TABLE_NAME,
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
            case FRUIT:
                return FoodContract.FruitEntry.CONTENT_TYPE;
            case VEGI:
                return FoodContract.VegiEntry.CONTENT_TYPE;
            case PROTEIN:
                return FoodContract.ProteinEntry.CONTENT_TYPE;
            case GRAIN:
                return FoodContract.GrainEntry.CONTENT_TYPE;
            case OTHER:
                return FoodContract.OtherEntry.CONTENT_TYPE;
            case MODERATE:
                return FoodContract.ModerateEntry.CONTENT_TYPE;
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
