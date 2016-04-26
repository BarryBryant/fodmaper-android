package com.b3sk.fodmaper.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Joopk on 4/14/2016.
 */
public class FoodContract {

    public static final String CONTENT_AUTHORITY = "com.b3sk.fodmaper";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_FODMAP = "fodmaps";
    public static final String PATH_FRUIT = "fruitFriend";
    public static final String PATH_VEGI = "vegiFriend";
    public static final String PATH_PROTEIN = "proteinFriend";
    public static final String PATH_GRAIN = "grainFriend";
    public static final String PATH_OTHER = "otherFriend";


    public static final class FodmapEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_FODMAP).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_FODMAP;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_FODMAP;

        public static final String TABLE_NAME = "fodmaps";

        public static final String COLUMN_FODMAP_NAME = "Name";

        public static final String COLUMN_FODMAP_INFO = "Info";

        public static final String COLUMN_FODMAP_ID = "_id";

        public static Uri buildFodmapUri() {
            return CONTENT_URI;
        }


    }

    public static final class FruitEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_FRUIT).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_FRUIT;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_FRUIT;

        public static final String TABLE_NAME = "fruitFriend";

        public static final String COLUMN_FRUIT_NAME = "Name";

        public static final String COLUMN_FRUIT_INFO = "Info";

        public static final String COLUMN_FRUIT_ID = "_id";

        public static Uri buildFruitUri() {
            return CONTENT_URI;
        }

    }

    public static final class VegiEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_VEGI).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_VEGI;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_VEGI;

        public static final String TABLE_NAME = "vegiFriend";

        public static final String COLUMN_FODMAP_NAME = "Name";

        public static final String COLUMN_FODMAP_INFO = "Info";

        public static final String COLUMN_FODMAP_ID = "_id";

        public static Uri buildVegiUri() {
            return CONTENT_URI;
        }

    }

    public static final class ProteinEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_PROTEIN).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PROTEIN;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PROTEIN;

        public static final String TABLE_NAME = "proteinFriend";

        public static final String COLUMN_PROTEIN_NAME = "Name";

        public static final String COLUMN_PROTEIN_INFO = "Info";

        public static final String COLUMN_PROTEIN_ID = "_id";

        public static Uri buildProteinUri() {
            return CONTENT_URI;
        }

    }

    public static final class GrainEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_GRAIN).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_GRAIN;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_GRAIN;

        public static final String TABLE_NAME = "grainFriend";

        public static final String COLUMN_GRAIN_NAME = "Name";

        public static final String COLUMN_GRAIN_INFO = "Info";

        public static final String COLUMN_GRAIN_ID = "_id";

        public static Uri buildGrainUri() {
            return CONTENT_URI;
        }

    }

    public static final class OtherEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_OTHER).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_OTHER;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_OTHER;

        public static final String TABLE_NAME = "otherFriend";

        public static final String COLUMN_OTHER_NAME = "Name";

        public static final String COLUMN_OTHER_INFO = "Info";

        public static final String COLUMN_OTHER_ID = "_id";

        public static Uri buildOtherUri() {
            return CONTENT_URI;
        }

    }


}
