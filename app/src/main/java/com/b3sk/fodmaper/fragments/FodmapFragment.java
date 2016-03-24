package com.b3sk.fodmaper.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.b3sk.fodmaper.R;
import com.b3sk.fodmaper.adapters.RecyclerViewAdapter;
import com.b3sk.fodmaper.models.Food;

import java.util.ArrayList;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class FodmapFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    private GridLayoutManager mLayout;

    public FodmapFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static FodmapFragment newInstance() {
        FodmapFragment fragment = new FodmapFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fodmap_list, container, false);
        List<Food> rowListItem = getAllItems();
        mLayout = new GridLayoutManager(getContext(), 2);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.fodmap_recycler);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(mLayout);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(
                getContext(), rowListItem);
        recyclerView.setAdapter(recyclerViewAdapter);

        return rootView;
    }

    private List<Food> getAllItems() {
        List<Food> allItems = new ArrayList<Food>();
        allItems.add(new Food("Food", 1, "Food"));
        allItems.add(new Food("Food", 1, "Food"));
        allItems.add(new Food("Food", 1, "Food"));
        allItems.add(new Food("Food", 1, "Food"));
        allItems.add(new Food("Food", 1, "Food"));
        allItems.add(new Food("Food", 1, "Food"));
        allItems.add(new Food("Food", 1, "Food"));
        allItems.add(new Food("Food", 1, "Food"));
        allItems.add(new Food("Food", 1, "Food"));
        allItems.add(new Food("Food", 1, "Food"));
        allItems.add(new Food("Food", 1, "Food"));
        allItems.add(new Food("Food", 1, "Food"));
        allItems.add(new Food("Food", 1, "Food"));
        allItems.add(new Food("Food", 1, "Food"));
        allItems.add(new Food("Food", 1, "Food"));
        allItems.add(new Food("Food", 1, "Food"));
        allItems.add(new Food("Food", 1, "Food"));
        allItems.add(new Food("Food", 1, "Food"));
        return allItems;
    }
}