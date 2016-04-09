package com.b3sk.fodmaper.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.b3sk.fodmaper.R;
import com.b3sk.fodmaper.adapters.MarginDecoration;
import com.b3sk.fodmaper.adapters.RecyclerViewAdapter;
import com.b3sk.fodmaper.data.FoodRepository;
import com.b3sk.fodmaper.helpers.FoodFilter;
import com.b3sk.fodmaper.helpers.MyApplication;
import com.b3sk.fodmaper.models.FodmapSearch;
import com.b3sk.fodmaper.models.Food;
import com.b3sk.fodmaper.presenter.FodmapPresenter;
import com.b3sk.fodmaper.presenter.PresenterManager;
import com.b3sk.fodmaper.view.FodmapView;

import java.util.ArrayList;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class FodmapFragment extends Fragment implements SearchView.OnQueryTextListener, FodmapView {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */

    private static final String LOG_TAG = FodmapFragment.class.getSimpleName();
    private GridLayoutManager mLayout;
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private FodmapPresenter presenter;

    public FodmapFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static FodmapFragment newInstance() {
        FodmapFragment fragment = new FodmapFragment();
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.bindView(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unbindView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(savedInstanceState == null) {
            presenter = new FodmapPresenter();
        }else {
            presenter = PresenterManager.getInstance().restorePresenter(savedInstanceState);
        }

        View rootView = inflater.inflate(R.layout.fodmap_list, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.fodmap_recycler);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mLayout = new GridLayoutManager(getContext(), 2);
        mRecyclerView.setLayoutManager(mLayout);

        int margin = MyApplication.getResourcesStatic().getDimensionPixelSize(R.dimen.card_margin);
        mRecyclerView.addItemDecoration(new MarginDecoration(margin));

        setHasOptionsMenu(true);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        PresenterManager.getInstance().savePresenter(presenter, outState);
    }



    @Override
    public boolean onQueryTextChange(String query) {
        presenter.onQueryTextChanged(query);
        return true;
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }


    @Override
    public void animateToFilter(List<Food> foodList) {
        mRecyclerViewAdapter.animateTo(foodList);
        mRecyclerView.scrollToPosition(0);
    }

    @Override
    public void bindFoods(List<Food> foodList) {
        mRecyclerViewAdapter = new RecyclerViewAdapter(getActivity(), foodList);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }

}