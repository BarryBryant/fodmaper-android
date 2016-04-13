package com.b3sk.fodmaper.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.b3sk.fodmaper.R;
import com.b3sk.fodmaper.helpers.MarginDecoration;
import com.b3sk.fodmaper.adapters.RecyclerViewAdapter;
import com.b3sk.fodmaper.helpers.MyApplication;
import com.b3sk.fodmaper.model.Food;
import com.b3sk.fodmaper.presenter.FriendlyPresenter;
import com.b3sk.fodmaper.presenter.PresenterManager;
import com.b3sk.fodmaper.view.FriendlyView;

import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class FodmapFriendlyFragment extends Fragment implements View.OnClickListener, FriendlyView {
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
    private FriendlyPresenter presenter;
    private ImageView fruit;
    private ImageView vegi;
    private ImageView meat;
    private ImageView dairy;
    private ImageView grain;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static FodmapFriendlyFragment newInstance() {
        FodmapFriendlyFragment fragment = new FodmapFriendlyFragment();
        return fragment;
    }

    @Override
    public void onResume() {
        Log.d(LOG_TAG, "onResume Called");
        super.onResume();
        presenter.bindView(this);
    }

    @Override
    public void onPause() {
        Log.d(LOG_TAG, "onPause Called");
        super.onPause();
        presenter.unbindView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fodmap_friendly_list, container, false);

        if(savedInstanceState == null) {
            presenter = new FriendlyPresenter();
        }else {
            presenter = PresenterManager.getInstance().restorePresenter(savedInstanceState);
        }

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.fodmap_recycler);
        meat = (ImageView) rootView.findViewById(R.id.meat_button);
        meat.setOnClickListener(this);
        vegi = (ImageView) rootView.findViewById(R.id.vegitable_button);
        vegi.setOnClickListener(this);
        fruit = (ImageView) rootView.findViewById(R.id.fruit_button);
        fruit.setOnClickListener(this);
        dairy = (ImageView) rootView.findViewById(R.id.dairy_button);
        dairy.setOnClickListener(this);
        grain = (ImageView) rootView.findViewById(R.id.grain_button);
        grain.setOnClickListener(this);
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
        Log.d(LOG_TAG, "SAVED STATE");
        super.onSaveInstanceState(outState);

        PresenterManager.getInstance().savePresenter(presenter, outState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.meat_button:
                presenter.onMeatClicked();
                break;
            case R.id.vegitable_button:
                presenter.onVegiClicked();
                break;
            case R.id.fruit_button:
                presenter.onFruitClicked();
                break;
            case R.id.dairy_button:
                presenter.onDairyClicked();
                break;
            case R.id.grain_button:
                presenter.onGrainClicked();
                break;
        }
    }

    @Override
    public void animateToFilter(List<Food> foodList) {
        mRecyclerViewAdapter.animateTo(foodList);
    }

    @Override
    public void bindFoods(List<Food> foodList) {
        mRecyclerViewAdapter = new RecyclerViewAdapter(getActivity(), foodList);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

    }

    @Override
    public void onFruitClicked(boolean clicked) {
        if(clicked) {
            fruit.setImageResource(R.drawable.meat_icon_clicked);
        }else {
            fruit.setImageResource(R.drawable.meat_icon);
        }
    }

    @Override
    public void onVegiClicked(boolean clicked) {
        if(clicked) {
            vegi.setImageResource(R.drawable.meat_icon_clicked);
        }else {
            vegi.setImageResource(R.drawable.meat_icon);
        }
    }

    @Override
    public void onMeatClicked(boolean clicked) {
        if(clicked) {
            meat.setImageResource(R.drawable.meat_icon_clicked);
        }else {
            meat.setImageResource(R.drawable.meat_icon);
        }
    }

    @Override
    public void onDairyClicked(boolean clicked) {
        if(clicked) {
            dairy.setImageResource(R.drawable.meat_icon_clicked);
        }else {
            dairy.setImageResource(R.drawable.meat_icon);
        }
    }

    @Override
    public void onGrainClicked(boolean clicked) {
        if(clicked) {
            grain.setImageResource(R.drawable.meat_icon_clicked);
        }else {
            grain.setImageResource(R.drawable.meat_icon);
        }
    }
}