package com.zemin.basic_core.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * @Date 2020/11/15 15:50
 * @Created by zemin
 */
public class FixedFragmentPagerAdapter extends FragmentPagerAdapter {
    private Fragment[] fragments;

    private String[] titles;

    public FixedFragmentPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public void setFragmentList(Fragment... fragments) {
        this.fragments = fragments;
    }

    public void setTitles(String... titles) {
        this.titles = titles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (titles != null && titles.length == getCount()) {
            return titles[position];
        }
        Fragment fragment = fragments[position];
        if (fragment instanceof PageTitle) {
            PageTitle pageTitle = (PageTitle) fragment;
            return pageTitle.getPageTitle();
        }
        return "";
    }

    public interface PageTitle {
        CharSequence getPageTitle();
    }
}
