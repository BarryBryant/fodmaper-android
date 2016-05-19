package com.b3sk.fodmaper.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;

import com.b3sk.fodmaper.R;
import com.b3sk.fodmaper.adapters.SectionsPagerAdapter;
import com.b3sk.fodmaper.fragments.FodmapFragment;
import com.b3sk.fodmaper.fragments.FodmapFriendlyFragment;
import com.b3sk.fodmaper.fragments.ModerateFodmapFragment;
import com.b3sk.fodmaper.helpers.MyApplication;
import com.b3sk.fodmaper.presenter.MainPresenter;
import com.b3sk.fodmaper.presenter.PresenterManager;
import com.b3sk.fodmaper.view.MainView;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class MainActivity extends AppCompatActivity implements MainView {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private MainPresenter presenter;
    private Tracker tracker;
    private boolean tablet;


    @Override
    public void onResume() {
        super.onResume();
        presenter.bindView(this);
        tracker.setScreenName("Image~" + "MainActivity");
        tracker.send(new HitBuilders.ScreenViewBuilder().build());

    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unbindView();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (findViewById(R.id.container_one) != null) {
            tablet = true;
        }

        if (!tablet) {

            // Create the adapter that will return a fragment for each of the three
            // primary sections of the activity.
            mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

            // Set up the ViewPager with the sections adapter.
            mViewPager = (ViewPager) findViewById(R.id.container);
            mViewPager.setAdapter(mSectionsPagerAdapter);

            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(mViewPager);
        } else {
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction().add(R.id.container_one,
                        FodmapFragment.newInstance()).commit();
                getSupportFragmentManager().beginTransaction().add(R.id.container_two,
                        FodmapFriendlyFragment.newInstance()).commit();
                getSupportFragmentManager().beginTransaction().add(R.id.container_three,
                        ModerateFodmapFragment.newInstance()).commit();
            }
        }


        if (savedInstanceState == null) {
            presenter = new MainPresenter();
        } else {
            presenter = PresenterManager.getInstance().restorePresenter(savedInstanceState);
        }

        MyApplication application = (MyApplication) getApplication();
        tracker = application.getDefaultTracker();

    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        PresenterManager.getInstance().savePresenter(presenter, outState);
    }

}
