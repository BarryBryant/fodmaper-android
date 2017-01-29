package com.b3sk.fodmaper.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.widget.RemoteViews;

import com.b3sk.fodmaper.R;

/**
 * Created by Joopk on 5/9/2016.
 */
public class DetailWidgetProvider extends AppWidgetProvider {

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // Perform this loop procedure for each App Widget that belongs to this provider
        for (int appWidgetId : appWidgetIds) {
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_detail);
            setRemoteAdapter(context, views);
            views.setEmptyView(R.id.widget_list, R.id.widget_empty);
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }

    @Override
    public void onReceive(@NonNull Context context, @NonNull Intent intent) {
        super.onReceive(context, intent);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(
                new ComponentName(context, getClass()));
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.widget_list);

    }

    /**
     * Sets the remote adapter used to fill in the list items
     *
     * @param views RemoteViews to set the RemoteAdapter
     */
    private void setRemoteAdapter(Context context, @NonNull final RemoteViews views) {
        views.setRemoteAdapter(R.id.widget_list,
                new Intent(context, DetailWidgetRemoteViewsService.class));
    }

}
