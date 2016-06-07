package com.b3sk.fodmaper.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.b3sk.fodmaper.R;
import com.b3sk.fodmaper.MyApplication;
import com.b3sk.fodmaper.model.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joopk on 3/23/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private final List<Food> mFoods;
    private final LayoutInflater mInflater;

    public RecyclerViewAdapter(Context context, List<Food> foods) {
        mFoods = new ArrayList<>(foods);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View foodView = mInflater.inflate(R.layout.list_item_fodmap, parent, false);
        return new RecyclerViewHolder(foodView);

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        holder.fodmapName.setText(mFoods.get(position).getName());

        if(mFoods.get(position).getF() == 1) {
            holder.fodmapF.setTextColor(MyApplication.getResourcesStatic().getColor(R.color.colorAccent));
        }else holder.fodmapF.setTextColor(MyApplication.getResourcesStatic().getColor(R.color.fontDisabled));

        if(mFoods.get(position).getO() == 1) {
            holder.fodmapO.setTextColor(MyApplication.getResourcesStatic().getColor(R.color.colorAccent));
        }else holder.fodmapO.setTextColor(MyApplication.getResourcesStatic().getColor(R.color.fontDisabled));

        if(mFoods.get(position).getD() == 1) {
            holder.fodmapD.setTextColor(MyApplication.getResourcesStatic().getColor(R.color.colorAccent));
        }else holder.fodmapD.setTextColor(MyApplication.getResourcesStatic().getColor(R.color.fontDisabled));

        if(mFoods.get(position).getM() == 1) {
            holder.fodmapM.setTextColor(MyApplication.getResourcesStatic().getColor(R.color.colorAccent));
        }else holder.fodmapM.setTextColor(MyApplication.getResourcesStatic().getColor(R.color.fontDisabled));

        if(mFoods.get(position).getP() == 1) {
            holder.fodmapP.setTextColor(MyApplication.getResourcesStatic().getColor(R.color.colorAccent));
        }else holder.fodmapP.setTextColor(MyApplication.getResourcesStatic().getColor(R.color.fontDisabled));


        int id = mFoods.get(position).getF();
        if(id == 1) {
            holder.fodmapView.setContentDescription(MyApplication.getAppContext().getString(
                    R.string.fodmap_description));
        }else {
            holder.fodmapView.setContentDescription(MyApplication.getAppContext().getString(
                    R.string.friendly_description));
        }

        holder.fodmapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Prevent index out of bounds
                if(position > mFoods.size()-1) {
                    Toast.makeText(v.getContext(), mFoods.get(0).getInfo(),
                            Toast.LENGTH_SHORT).show();
                } else {
                Toast.makeText(v.getContext(), mFoods.get(position).getInfo(),
                        Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return this.mFoods.size();
    }

    public void animateTo(List<Food> foods) {
        applyAndAnimateRemovals(foods);
        applyAndAnimateAdditions(foods);
        applyAndAnimateMovedItems(foods);

    }

    private void applyAndAnimateRemovals(List<Food> newFoods) {
        for (int i = mFoods.size() - 1; i >= 0; i--) {
            final Food food = mFoods.get(i);
            if (!newFoods.contains(food)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<Food> newFoods) {
        for (int i = 0, count = newFoods.size(); i < count; i++) {
            final Food food = newFoods.get(i);
            if (!mFoods.contains(food)) {
                addItem(i, food);
            }
        }
    }

    private void applyAndAnimateMovedItems(List<Food> newFoods) {
        for (int toPosition = newFoods.size() - 1; toPosition >= 0; toPosition--) {
            final Food food = newFoods.get(toPosition);
            final int fromPosition = mFoods.indexOf(food);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public Food removeItem(int position) {
        final Food food = mFoods.remove(position);
        notifyItemRemoved(position);
        return food;
    }

    public void addItem(int position, Food food) {
        mFoods.add(position, food);
        notifyItemInserted(position);
    }

    public void moveItem(int fromPosition, int toPosition) {
        final Food food = mFoods.remove(fromPosition);
        mFoods.add(toPosition, food);
        notifyItemMoved(fromPosition, toPosition);
    }


}