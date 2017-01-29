package com.b3sk.fodmaper.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.b3sk.fodmaper.MyApplication;
import com.b3sk.fodmaper.R;
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
        int f = mFoods.get(position).getF();

        //Check if food item is high or moderate fodmap and set accent color accordingly
        int flagColor = MyApplication.getResourcesStatic().getColor(R.color.fontDisabled);
        int disabledColor = MyApplication.getResourcesStatic().getColor(R.color.fontDisabled);

        if (f == 2) flagColor = MyApplication.getResourcesStatic().getColor(R.color.colorAccent);
        if (f == 1)
            flagColor = MyApplication.getResourcesStatic().getColor(R.color.colorModerateAccent);

        //Set colors of each letter in FODMAP according to its presence in the Food
        //Moderate foods flag as orange, high flag as red

        holder.fodmapF.setTextColor(flagColor);

        if (mFoods.get(position).getO() == 1) {
            holder.fodmapO.setTextColor(flagColor);
        } else holder.fodmapO.setTextColor(disabledColor);

        if (mFoods.get(position).getD() == 1) {
            holder.fodmapD.setTextColor(flagColor);
        } else holder.fodmapD.setTextColor(disabledColor);

        if (mFoods.get(position).getM() == 1) {
            holder.fodmapM.setTextColor(flagColor);
        } else holder.fodmapM.setTextColor(disabledColor);

        if (mFoods.get(position).getP() == 1) {
            holder.fodmapP.setTextColor(flagColor);
        } else holder.fodmapP.setTextColor(disabledColor);


        //set content descriptions
        if (f > 0) {
            holder.fodmapView.setContentDescription(MyApplication.getAppContext().getString(
                    R.string.fodmap_description));
        } else {
            holder.fodmapView.setContentDescription(MyApplication.getAppContext().getString(
                    R.string.friendly_description));
        }

        holder.fodmapView.setOnClickListener((v) -> {
            //Prevent index out of bounds
            if (position > mFoods.size() - 1) {
                Toast.makeText(v.getContext(), mFoods.get(0).getInfo(),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(v.getContext(), mFoods.get(position).getInfo(),
                        Toast.LENGTH_SHORT).show();
            }

        });


    }

    @Override
    public int getItemCount() {
        return this.mFoods.size();
    }

    public void animateTo(List<Food> foods) {
        mFoods.clear();
        mFoods.addAll(foods);
        notifyDataSetChanged();

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