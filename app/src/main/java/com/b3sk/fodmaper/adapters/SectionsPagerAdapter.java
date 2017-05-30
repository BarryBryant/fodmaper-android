package com.b3sk.fodmaper.adapters;

/**
 * Created by Joopk on 3/23/2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.b3sk.fodmaper.MyApplication;
import com.b3sk.fodmaper.R;
import com.b3sk.fodmaper.fragments.FodmapFragment;
import com.b3sk.fodmaper.fragments.FodmapFriendlyFragment;
import com.b3sk.fodmaper.fragments.ModerateFodmapFragment;
import com.b3sk.fodmaper.fragments.SearchAllFragment;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return SearchAllFragment.newInstance();
            case 1:
                return FodmapFragment.newInstance();
            case 2:
                return ModerateFodmapFragment.newInstance();
            case 3:
                return FodmapFriendlyFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        boolean nullContext = MyApplication.getResourcesStatic() == null;
        switch (position) {
            case 0:
                return nullContext ? "All Foods" : MyApplication.getResourcesStatic().getString(
                        R.string.ALL_fragment);
            case 1:
                return nullContext ? "High FODMAP Foods" : MyApplication.getResourcesStatic().getString(
                        R.string.FODMAP_fragment);
            case 2:
                return nullContext ? "Moderate FODMAP Foods" : MyApplication.getResourcesStatic().getString(
                        R.string.moderate_FODMAP_fragment);
            case 3:
                return nullContext ? "FODMAP Friendly Foods" : MyApplication.getResourcesStatic().getString(
                        R.string.FODMAP_friendly_fragment);

        }
        return null;
    }
}
