package com.b3sk.fodmaper.helpers;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Joopk on 3/24/2016.
 */
public class MarginDecoration extends RecyclerView.ItemDecoration {

    private int margin;

    public MarginDecoration(int margin) {
        this.margin = margin;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent,RecyclerView.State state) {
        outRect.left = margin/2;
        outRect.right = margin/2;
        outRect.top = margin/2;
        outRect.bottom = margin/2;

    }
}
