package com.b3sk.fodmaper.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.b3sk.fodmaper.R;
import com.b3sk.fodmaper.adapters.SectionsPagerAdapter;
import com.b3sk.fodmaper.fragments.FodmapFragment;
import com.b3sk.fodmaper.fragments.FodmapFriendlyFragment;
import com.b3sk.fodmaper.fragments.ModerateFodmapFragment;
import com.b3sk.fodmaper.MyApplication;
import com.b3sk.fodmaper.view.MainView;
import com.google.android.gms.ads.MobileAds;
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
    private SectionsPagerAdapter sectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager viewPager;
    private Tracker tracker;
    private boolean tablet;


    @Override
    public void onResume() {
        super.onResume();
        tracker.setScreenName("Image~" + "MainActivity");
        tracker.send(new HitBuilders.ScreenViewBuilder().build());

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
            sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

            // Set up the ViewPager with the sections adapter.
            viewPager = (ViewPager) findViewById(R.id.container);
            viewPager.setOffscreenPageLimit(2);
            viewPager.setAdapter(sectionsPagerAdapter);

            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(viewPager);

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

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



        MobileAds.initialize(getApplicationContext(),
                getResources().getString(R.string.banner_ad_app_id));
        MyApplication application = (MyApplication) getApplication();
        tracker = application.getDefaultTracker();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}
