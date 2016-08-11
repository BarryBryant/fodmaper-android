package com.b3sk.fodmaper.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.b3sk.fodmaper.MyApplication;
import com.b3sk.fodmaper.R;
import com.b3sk.fodmaper.adapters.RecyclerViewAdapter;
import com.b3sk.fodmaper.adapters.SearchAllRecyclerViewAdapter;
import com.b3sk.fodmaper.model.Food;
import com.b3sk.fodmaper.model.FoodRepo;
import com.b3sk.fodmaper.presenter.FodmapPresenterImpl;
import com.b3sk.fodmaper.presenter.PresenterManager;
import com.b3sk.fodmaper.presenter.SearchAllPresenterImpl;
import com.b3sk.fodmaper.view.FodmapView;

import java.util.List;

import javax.inject.Inject;

public class SearchAllActivity extends AppCompatActivity implements FodmapView, TextWatcher {

    private RecyclerView recyclerView;
    private SearchAllRecyclerViewAdapter recyclerViewAdapter;
    private SearchAllPresenterImpl presenter;

    @Inject
    FoodRepo foodRepo;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_all);
        ((MyApplication) getApplication()).getComponent().inject(this);


        if(savedInstanceState == null) {
            presenter = new SearchAllPresenterImpl(foodRepo);
        }else {
            presenter = PresenterManager.getInstance().restorePresenter(savedInstanceState);
            if(presenter == null) {
                presenter = new SearchAllPresenterImpl(foodRepo);
            }
        }

        recyclerView = (RecyclerView) findViewById(R.id.fodmap_recycler);
        EditText searchText = (EditText) findViewById(R.id.fodmap_search_text);
        searchText.addTextChangedListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


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
        recyclerViewAdapter = new SearchAllRecyclerViewAdapter(this, foodList);
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
