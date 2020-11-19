package com.zemin.wanandroid.module.main.fragment;

import android.widget.LinearLayout;

import androidx.viewpager.widget.ViewPager;

import com.zemin.basic_core.adapter.tab.Page;
import com.zemin.basic_core.adapter.tab.TabFragmentPagerAdapter;
import com.zemin.basic_core.base.BaseFragment;
import com.zemin.basic_core.mvp.MvpPresenter;
import com.zemin.wanandroid.R;
import com.zemin.wanandroid.module.home.fragment.HomeFragment;
import com.zemin.wanandroid.module.main.adapter.MainAdapter;
import com.zemin.wanandroid.module.main.model.TabEntity;

/**
 * @Date 2020/11/15 16:06
 * @Author  by ZeMin
 */
public class MainFragment extends BaseFragment {
    private ViewPager tabViewPager;

    private LinearLayout bottomNavgation;

    public static MainFragment create() {
        return new MainFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_main;
    }

    @Override
    protected MvpPresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        tabViewPager = (ViewPager) findViewById(R.id.vp_tab);
        bottomNavgation = (LinearLayout) findViewById(R.id.ll_bottom);
        TabFragmentPagerAdapter<TabEntity> pagerAdapter = new TabFragmentPagerAdapter<>(getChildFragmentManager(),
                tabViewPager, bottomNavgation);
        pagerAdapter.setPages(
                new Page<>(HomeFragment.create(), new TabEntity(getString(R.string.tab_home_name), R.drawable.ic_bottom_bar_home, R.layout.tab_item_main), new MainAdapter()),
                new Page<>(HomeFragment.create(), new TabEntity(getString(R.string.tab_home_name), R.drawable.ic_bottom_bar_home, R.layout.tab_item_main), new MainAdapter())
        );
        tabViewPager.setAdapter(pagerAdapter);
    }

    @Override
    protected void loadData() {

    }
}
