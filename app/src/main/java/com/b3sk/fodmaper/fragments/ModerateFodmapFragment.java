package com.b3sk.fodmaper.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.b3sk.fodmaper.R;
import com.b3sk.fodmaper.adapters.RecyclerViewAdapter;
import com.b3sk.fodmaper.model.Food;
import com.b3sk.fodmaper.model.RealmFoodRepoImpl;
import com.b3sk.fodmaper.presenter.ModeratePresenterImpl;
import com.b3sk.fodmaper.view.ModerateFodmapView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class ModerateFodmapFragment extends Fragment implements ModerateFodmapView {
    private RecyclerView recyclerView;
    private ModeratePresenterImpl presenter;

    public ModerateFodmapFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ModerateFodmapFragment newInstance() {
        return new ModerateFodmapFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.bindView(this);
        presenter.loadFood();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unbindView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            presenter = new ModeratePresenterImpl(new RealmFoodRepoImpl());
        } else if (presenter == null) {
            presenter = new ModeratePresenterImpl(new RealmFoodRepoImpl());
        }

        View rootView = inflater.inflate(R.layout.moderate_fodmap_list, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.moderate_recycler);

        AdView adView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adView.loadAd(adRequest);

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
    }

    @Override
    public void bindFoods(List<Food> foodList) {
        RecyclerViewAdapter mRecyclerViewAdapter = new RecyclerViewAdapter(getActivity(), foodList);
        recyclerView.setAdapter(mRecyclerViewAdapter);
    }


}