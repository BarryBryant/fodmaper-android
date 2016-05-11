package com.b3sk.fodmaper.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.b3sk.fodmaper.R;
import com.b3sk.fodmaper.adapters.RecyclerViewAdapter;
import com.b3sk.fodmaper.data.FoodContract;
import com.b3sk.fodmaper.helpers.MarginDecoration;
import com.b3sk.fodmaper.helpers.MyApplication;
import com.b3sk.fodmaper.model.Food;
import com.b3sk.fodmaper.presenter.FodmapPresenter;
import com.b3sk.fodmaper.presenter.ModerateFodmapPresenter;
import com.b3sk.fodmaper.presenter.PresenterManager;
import com.b3sk.fodmaper.view.ModerateFodmapView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class ModerateFodmapFragment extends Fragment implements ModerateFodmapView,
        LoaderManager.LoaderCallbacks<Cursor> {
    private static final String LOG_TAG = ModerateFodmapFragment.class.getSimpleName();
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
        getLoaderManager().restartLoader(0, null, this);
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
            if(presenter == null) {
                presenter = new ModerateFodmapPresenter();
            }
        }

        View rootView = inflater.inflate(R.layout.moderate_fodmap_list, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.moderate_recycler);

        AdView adView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adView.loadAd(adRequest);
        getLoaderManager().initLoader(0, null, this);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mLayout = new GridLayoutManager(getContext(), getResources().getConfiguration().orientation);
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

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] columns = {FoodContract.ModerateEntry.COLUMN_MODERATE_NAME,
                FoodContract.ModerateEntry.COLUMN_MODERATE_F,
                FoodContract.ModerateEntry.COLUMN_MODERATE_O,
                FoodContract.ModerateEntry.COLUMN_MODERATE_D,
                FoodContract.ModerateEntry.COLUMN_MODERATE_M,
                FoodContract.ModerateEntry.COLUMN_MODERATE_P};

        return new CursorLoader(MyApplication.getAppContext(),
                FoodContract.ModerateEntry.buildModerateUri(),
                columns,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        List<Food> foods = new ArrayList<>();
        while(cursor!= null && cursor.moveToNext()) {
            foods.add(new Food(cursor.getString(0), cursor.getInt(1), cursor.getInt(2),
                    cursor.getInt(3), cursor.getInt(4), cursor.getInt(5)));
        }
        mRecyclerViewAdapter = new RecyclerViewAdapter(getActivity(), foods);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
    }
}