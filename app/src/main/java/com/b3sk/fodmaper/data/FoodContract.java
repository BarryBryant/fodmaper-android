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
}
