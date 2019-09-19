package com.example.deafspace.childrenspace.modules.historymodule.adapters;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class HistoryPartFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    public HistoryPartFragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragmentList = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
