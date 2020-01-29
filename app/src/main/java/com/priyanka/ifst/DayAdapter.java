package com.priyanka.ifst;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class DayAdapter extends FragmentStatePagerAdapter {
    private static final int TOTAL_PAGES = 2;

    public DayAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
             return new day1();
            case 1 :
                return new day2();
        }
        return null;
    }

    @Override
    public int getCount() {
        return TOTAL_PAGES;
    }
}
