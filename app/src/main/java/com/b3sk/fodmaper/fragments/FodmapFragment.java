package com.b3sk.fodmaper.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

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
public class FodmapFragment extends Fragment implements SearchView.OnQueryTextListener {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String LOG_TAG = FodmapFragment.class.getSimpleName();
    private GridLayoutManager mLayout;
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private List<Food> mFoods;
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
        mFoods = getAllItems();
        mLayout = new GridLayoutManager(getContext(), 2);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.fodmap_recycler);
        mRecyclerView.hasFixedSize();
        int margin = MyApplication.getResourcesStatic().getDimensionPixelSize(R.dimen.card_margin);
        mRecyclerView.addItemDecoration(new MarginDecoration(margin));
        mRecyclerView.setLayoutManager(mLayout);

        mRecyclerViewAdapter = new RecyclerViewAdapter(
                getActivity(), mFoods);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        setHasOptionsMenu(true);
        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fodmap_menu, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextChange(String query) {
        final List<Food> filteredFoodList = filter(mFoods, query);
        Log.d(LOG_TAG, "Filt:"+filteredFoodList.size()+"Mfood"+mFoods.size());
        mRecyclerViewAdapter.animateTo(filteredFoodList);
        Log.d(LOG_TAG, "Filt:" + filteredFoodList.size() + "Mfood" + mFoods.size());
        mRecyclerView.scrollToPosition(0);

        return true;
    }

    private List<Food> filter(List<Food> foods, String query) {
        query = query.toLowerCase();

        final List<Food> filteredFoodList = new ArrayList<>();
        for (Food food : foods) {
            final String text = food.getName().toLowerCase();
            if (text.contains(query)) {
                filteredFoodList.add(food);
            }
        }
        return filteredFoodList;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
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