package com.b3sk.fodmaper.fragments;

/**
 * Created by barrybryant on 5/29/17.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.b3sk.fodmaper.MyApplication;
import com.b3sk.fodmaper.R;
import com.b3sk.fodmaper.adapters.RecyclerViewAdapter;
import com.b3sk.fodmaper.model.Food;
import com.b3sk.fodmaper.model.FoodRepo;
import com.b3sk.fodmaper.presenter.FodmapPresenter;
import com.b3sk.fodmaper.presenter.PresenterManager;
import com.b3sk.fodmaper.presenter.SearchAllPresenterImpl;
import com.b3sk.fodmaper.view.FodmapView;

import java.util.List;

import javax.inject.Inject;



/**
 * A placeholder fragment containing a simple view.
 */
public class SearchAllFragment extends Fragment implements FodmapView, TextWatcher {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private FodmapPresenter presenter;

    @Inject
    FoodRepo foodRepo;

    public SearchAllFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SearchAllFragment newInstance() {
        return new SearchAllFragment();
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApplication) getActivity().getApplication()).getComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(savedInstanceState == null) {
            presenter = new SearchAllPresenterImpl(foodRepo);
        }else {
            presenter = PresenterManager.getInstance().restorePresenter(savedInstanceState);
            if(presenter == null) {
                presenter = new SearchAllPresenterImpl(foodRepo);
            }
        }

        View rootView = inflater.inflate(R.layout.fodmap_list, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.fodmap_recycler);
        EditText searchText = (EditText) rootView.findViewById(R.id.fodmap_search_text);
        searchText.addTextChangedListener(this);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        setHasOptionsMenu(true);

    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        PresenterManager.getInstance().savePresenter(presenter, outState);
    }

    @Override
    public void animateToFilter(List<Food> foodList) {
        recyclerViewAdapter.animateTo(foodList);
        recyclerView.scrollToPosition(0);
    }

    @Override
    public void bindFoods(List<Food> foodList) {
        recyclerViewAdapter = new RecyclerViewAdapter(getActivity(), foodList);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if(presenter!= null) {
            presenter.onQueryTextChanged(s.toString());
        }
    }

    @Override
    public void afterTextChanged(Editable s) {}
}
