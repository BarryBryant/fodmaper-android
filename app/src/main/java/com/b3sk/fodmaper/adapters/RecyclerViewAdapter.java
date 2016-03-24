package com.b3sk.fodmaper.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.b3sk.fodmaper.helpers.FoodPhotoRetriever;
import com.b3sk.fodmaper.R;
import com.b3sk.fodmaper.models.Food;

import java.util.List;

/**
 * Created by Joopk on 3/23/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {

    private List<Food> itemList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<Food> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_fodmap, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.fodmapName.setText(itemList.get(position).getName());
        holder.fodmapInfo.setText(itemList.get(position).getInfo());
        holder.fodmapPhoto.setImageResource(FoodPhotoRetriever.getFoodPhoto(
                itemList.get(position).getId()));
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}