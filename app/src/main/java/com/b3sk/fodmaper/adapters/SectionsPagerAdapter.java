package com.b3sk.fodmaper.adapters;

/**
 * Created by Joopk on 3/23/2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.b3sk.fodmaper.helpers.MyApplication;
import com.b3sk.fodmaper.R;
import com.b3sk.fodmaper.fragments.FodmapFragment;
import com.b3sk.fodmaper.fragments.FodmapFriendlyFragment;
import com.b3sk.fodmaper.fragments.ModerateFodmapFragment;

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
                return FodmapFragment.newInstance();
            case 1:
                return ModerateFodmapFragment.newInstance();
            case 2:
                return FodmapFriendlyFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return MyApplication.getResourcesStatic().getString(
                        R.string.FODMAP_fragment);
            case 1:
                return MyApplication.getResourcesStatic().getString(
                        R.string.moderate_FODMAP_fragment);
            case 2:
                return MyApplication.getResourcesStatic().getString(
                        R.string.FODMAP_friendly_fragment);

        }
        return null;
    }
}
