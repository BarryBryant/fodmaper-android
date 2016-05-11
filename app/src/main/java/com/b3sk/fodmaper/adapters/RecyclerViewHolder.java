package com.b3sk.fodmaper.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.b3sk.fodmaper.R;

import org.w3c.dom.Text;

/**
 * Created by Joopk on 3/23/2016.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView fodmapName;
    public TextView fodmapF;
    public TextView fodmapO;
    public TextView fodmapD;
    public TextView fodmapM;
    public TextView fodmapP;
    public View fodmapView;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        fodmapView = itemView;
        fodmapName = (TextView)itemView.findViewById(R.id.food_name);
        fodmapF = (TextView)itemView.findViewById(R.id.fodmap_F);
        fodmapO = (TextView)itemView.findViewById(R.id.fodmap_O);
        fodmapD = (TextView)itemView.findViewById(R.id.fodmap_D);
        fodmapM = (TextView)itemView.findViewById(R.id.fodmap_M);
        fodmapP = (TextView)itemView.findViewById(R.id.fodmap_AP);


    }

}
