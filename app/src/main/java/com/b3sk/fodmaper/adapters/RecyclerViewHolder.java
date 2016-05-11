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
public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView fodmapName;
    public TextView fodmapInfo;
    public ImageView fodmapPhoto;
    public View fodmapView;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        fodmapView = itemView;
        fodmapName = (TextView)itemView.findViewById(R.id.food_name);
//        fodmapInfo = (TextView)itemView.findViewById(R.id.additional_info);
//        fodmapPhoto = (ImageView)itemView.findViewById(R.id.food_photo);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked Food At Position =" +
                " " + getPosition(), Toast.LENGTH_SHORT).show();
    }
}
