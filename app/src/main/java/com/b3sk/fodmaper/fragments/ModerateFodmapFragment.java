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
import com.b3sk.fodmaper.helpers.MarginDecoration;
import com.b3sk.fodmaper.helpers.MyApplication;
import com.b3sk.fodmaper.model.Food;
import com.b3sk.fodmaper.presenter.FodmapPresenter;
import com.b3sk.fodmaper.presenter.ModerateFodmapPresenter;
import com.b3sk.fodmaper.presenter.PresenterManager;
import com.b3sk.fodmaper.view.ModerateFodmapView;

import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class ModerateFodmapFragment extends Fragment implements ModerateFodmapView {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private GridLayoutManager mLayout;
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private ModerateFodmapPresenter presenter;

    public ModerateFodmapFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ModerateFodmapFragment newInstance() {
        ModerateFodmapFragment fragment = new ModerateFodmapFragment();
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
            presenter = new ModerateFodmapPresenter();
        }else {
            presenter = PresenterManager.getInstance().restorePresenter(savedInstanceState);
        }

        View rootView = inflater.inflate(R.layout.moderate_fodmap_list, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.moderate_recycler);
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
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        PresenterManager.getInstance().savePresenter(presenter, outState);
    }

    @Override
    public void bindFoods(List<Food> foodList) {
        mRecyclerViewAdapter = new RecyclerViewAdapter(getActivity(), foodList);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }
}