package com.b3sk.fodmaper.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.b3sk.fodmaper.MyApplication;
import com.b3sk.fodmaper.R;
import com.b3sk.fodmaper.adapters.SectionsPagerAdapter;
import com.b3sk.fodmaper.fragments.FodmapFragment;
import com.b3sk.fodmaper.fragments.FodmapFriendlyFragment;
import com.b3sk.fodmaper.fragments.ModerateFodmapFragment;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

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
            SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

            // Set up the ViewPager with the sections adapter.
            viewPager = (ViewPager) findViewById(R.id.container);
            viewPager.setOffscreenPageLimit(2);
            viewPager.setAdapter(sectionsPagerAdapter);
            viewPager.addOnPageChangeListener(this);

            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(viewPager);

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);

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


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_friendly) {
            viewPager.setCurrentItem(2, true);
        } else if (id == R.id.nav_moderate) {
            viewPager.setCurrentItem(1, true);
        } else if (id == R.id.nav_high) {
            viewPager.setCurrentItem(0, true);
        } else if (id == R.id.nav_search) {
            Intent intent = new Intent(this, SearchAllActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "CHECK OUT THIS INCREDIBLE APP");
            startActivity(Intent.createChooser(shareIntent, "Tell a friend about FODMAPer"));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}
