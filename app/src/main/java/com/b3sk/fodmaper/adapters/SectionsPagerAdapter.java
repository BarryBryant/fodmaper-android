package com.b3sk.fodmaper.adapters;

/**
 * Created by Joopk on 3/23/2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.b3sk.fodmaper.helpers.MyApplication;
import com.b3sk.fodmaper.R;
import com.b3sk.fodmaper.fragments.FodmapFragment;
import com.b3sk.fodmaper.fragments.FodmapFriendlyFragment;
import com.b3sk.fodmaper.fragments.OcrFragment;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a FodmapFriendlyFragment (defined as a static inner class below).
        //return FodmapFriendlyFragment.newInstance(position + 1);
        switch (position) {
            case 0:
                return FodmapFriendlyFragment.newInstance();
            case 1:
                return FodmapFragment.newInstance();
            case 2:
                return OcrFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return MyApplication.getResourcesStatic().getString(
                        R.string.FODMAP_friendly_fragment);
            case 1:
                return MyApplication.getResourcesStatic().getString(
                        R.string.FODMAP_fragment);
            case 2:
                return MyApplication.getResourcesStatic().getString(
                        R.string.OCR_fragment);
        }
        return null;
    }
}
