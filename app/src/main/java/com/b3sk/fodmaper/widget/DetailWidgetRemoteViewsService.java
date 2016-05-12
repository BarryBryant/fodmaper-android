package com.b3sk.fodmaper.widget;

import android.annotation.TargetApi;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.b3sk.fodmaper.R;
import com.b3sk.fodmaper.data.FoodContract;

import java.text.SimpleDateFormat;

/**
 * Created by Joopk on 5/9/2016.
 */
public class DetailWidgetRemoteViewsService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new RemoteViewsFactory() {
            private Cursor data = null;

            @Override
            public void onCreate() {
                // Nothing to do
            }

            @Override
            public void onDataSetChanged() {
                if (data != null) {
                    data.close();
                }
                // This method is called by the app hosting the widget (e.g., the launcher)
                // However, our ContentProvider is not exported so it doesn't have access to the
                // data. Therefore we need to clear (and finally restore) the calling identity so
                // that calls use our process and permission
                final long identityToken = Binder.clearCallingIdentity();
                String[] columns = {FoodContract.ModerateEntry.COLUMN_MODERATE_NAME,
                        FoodContract.ModerateEntry.COLUMN_MODERATE_F,
                        FoodContract.ModerateEntry.COLUMN_MODERATE_O,
                        FoodContract.ModerateEntry.COLUMN_MODERATE_D,
                        FoodContract.ModerateEntry.COLUMN_MODERATE_M,
                        FoodContract.ModerateEntry.COLUMN_MODERATE_P,
                        "_id"};
                Uri foodUri = FoodContract.FodmapEntry.buildFodmapUri();
                data = getContentResolver().query(foodUri,
                        columns,
                        null,
                        null,
                        FoodContract.FodmapEntry.COLUMN_FODMAP_NAME + " ASC");
                Binder.restoreCallingIdentity(identityToken);
            }

            @Override
            public void onDestroy() {
                if (data != null) {
                    data.close();
                    data = null;
                }
            }

            @Override
            public int getCount() {
                return data == null ? 0 : data.getCount();
            }

            @Override
            public RemoteViews getViewAt(int position) {
                if (position == AdapterView.INVALID_POSITION ||
                        data == null || !data.moveToPosition(position)) {
                    return null;
                }


                RemoteViews views = new RemoteViews(getPackageName(),
                        R.layout.widget_detail_list_item);

                String foodName = data.getString(0);
                views.setTextViewText(R.id.widget_item, foodName);




                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
                    setRemoteContentDescription(views, getString(R.string.fodmap_description));
                }


                return views;
            }

            @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
            private void setRemoteContentDescription(RemoteViews views, String description) {
                views.setContentDescription(R.id.widget_item, getString(R.string.fodmap_description));
            }

            @Override
            public RemoteViews getLoadingView() {
                return new RemoteViews(getPackageName(), R.layout.widget_detail_list_item);
            }

            @Override
            public int getViewTypeCount() {
                return 1;
            }

            @Override
            public long getItemId(int position) {
                if (data.moveToPosition(position))
                    return data.getLong(6);
                return position;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }
        };
    }
}