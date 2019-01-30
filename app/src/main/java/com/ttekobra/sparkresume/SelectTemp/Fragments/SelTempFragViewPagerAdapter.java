package com.ttekobra.sparkresume.SelectTemp.Fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class SelTempFragViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragmentList = new ArrayList<>();

    public SelTempFragViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    public SelTempFragViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void addFragments(Fragment fragment) {
        fragmentList.add(fragment);
    }
}