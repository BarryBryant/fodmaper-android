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
    public static final String PATH_MODERATE = "moderates";


    public static final class FodmapEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_FODMAP).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_FODMAP;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_FODMAP;

        public static final String TABLE_NAME = "fodmaps";

        public static final String COLUMN_FODMAP_NAME = "NAME";

        public static final String COLUMN_FODMAP_F = "F";

        public static final String COLUMN_FODMAP_O = "O";

        public static final String COLUMN_FODMAP_D = "D";

        public static final String COLUMN_FODMAP_M = "M";

        public static final String COLUMN_FODMAP_P = "P";

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

        public static final String COLUMN_FRUIT_NAME = "NAME";

        public static final String COLUMN_FRUIT_F = "F";

        public static final String COLUMN_FRUIT_O = "O";

        public static final String COLUMN_FRUIT_D = "D";

        public static final String COLUMN_FRUIT_M = "M";

        public static final String COLUMN_FRUIT_P = "P";

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

        public static final String COLUMN_VEGI_NAME = "NAME";

        public static final String COLUMN_VEGI_F = "F";

        public static final String COLUMN_VEGI_O = "O";

        public static final String COLUMN_VEGI_D = "D";

        public static final String COLUMN_VEGI_M = "M";

        public static final String COLUMN_VEGI_P = "P";

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

        public static final String COLUMN_PROTEIN_NAME = "NAME";

        public static final String COLUMN_PROTEIN_F = "F";

        public static final String COLUMN_PROTEIN_O = "O";

        public static final String COLUMN_PROTEIN_D = "D";

        public static final String COLUMN_PROTEIN_M = "M";

        public static final String COLUMN_PROTEIN_P = "P";

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

        public static final String COLUMN_GRAIN_NAME = "NAME";

        public static final String COLUMN_GRAIN_F = "F";

        public static final String COLUMN_GRAIN_O = "O";

        public static final String COLUMN_GRAIN_D = "D";

        public static final String COLUMN_GRAIN_M = "M";

        public static final String COLUMN_GRAIN_P = "P";

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

        public static final String COLUMN_OTHER_NAME = "NAME";

        public static final String COLUMN_OTHER_F = "F";

        public static final String COLUMN_OTHER_O = "O";

        public static final String COLUMN_OTHER_D = "D";

        public static final String COLUMN_OTHER_M = "M";

        public static final String COLUMN_OTHER_P = "P";

        public static Uri buildOtherUri() {
            return CONTENT_URI;
        }

    }

    public static final class ModerateEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_MODERATE).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MODERATE;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MODERATE;

        public static final String TABLE_NAME = "moderates";

        public static final String COLUMN_MODERATE_NAME = "NAME";

        public static final String COLUMN_MODERATE_F = "F";

        public static final String COLUMN_MODERATE_O = "O";

        public static final String COLUMN_MODERATE_D = "D";

        public static final String COLUMN_MODERATE_M = "M";

        public static final String COLUMN_MODERATE_P = "P";

        public static Uri buildModerateUri() {
            return CONTENT_URI;
        }

    }


}
