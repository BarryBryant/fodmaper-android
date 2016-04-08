package com.b3sk.fodmaper.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.b3sk.fodmaper.R;
import com.b3sk.fodmaper.adapters.MarginDecoration;
import com.b3sk.fodmaper.adapters.RecyclerViewAdapter;
import com.b3sk.fodmaper.helpers.MyApplication;
import com.b3sk.fodmaper.models.Food;

import java.util.ArrayList;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class FodmapFriendlyFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */


    public FodmapFriendlyFragment() {
    }

    private static final String LOG_TAG = FodmapFragment.class.getSimpleName();
    private GridLayoutManager mLayout;
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private List<Food> mFoods;


    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static FodmapFriendlyFragment newInstance() {
        FodmapFriendlyFragment fragment = new FodmapFriendlyFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fodmap_list, container, false);
        mFoods = getAllItems();
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.fodmap_recycler);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mLayout = new GridLayoutManager(getContext(), 2);
        mRecyclerView.setLayoutManager(mLayout);

        int margin = MyApplication.getResourcesStatic().getDimensionPixelSize(R.dimen.card_margin);
        mRecyclerView.addItemDecoration(new MarginDecoration(margin));

        mRecyclerViewAdapter = new RecyclerViewAdapter(getActivity(), mFoods);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        setHasOptionsMenu(true);
    }

    private List<Food> getAllItems() {
        List<Food> allItems = new ArrayList<Food>();
        allItems.add(new Food("Alpha", 1, "Food"));
        allItems.add(new Food("Beta", 1, "Food"));
        allItems.add(new Food("Charlie", 1, "Food"));
        allItems.add(new Food("Delta", 1, "Food"));
        allItems.add(new Food("Echo", 1, "Food"));
        allItems.add(new Food("Foxtrot", 1, "Food"));
        allItems.add(new Food("Gamma", 1, "Food"));
        allItems.add(new Food("Halo", 1, "Food"));
        allItems.add(new Food("Ingrown Hair", 1, "Food"));
        allItems.add(new Food("Janky", 1, "Food"));
        allItems.add(new Food("Kilo", 1, "Food"));
        allItems.add(new Food("Lima", 1, "Food"));
        allItems.add(new Food("Mango", 1, "Food"));
        allItems.add(new Food("Nitric Acid", 1, "Food"));
        allItems.add(new Food("Oxford", 1, "Food"));
        allItems.add(new Food("Porter John", 1, "Food"));
        allItems.add(new Food("Query", 1, "Food"));
        allItems.add(new Food("Romeo", 1, "Food"));
        return allItems;
    }
}