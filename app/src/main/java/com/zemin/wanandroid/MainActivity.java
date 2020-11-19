package com.zemin.wanandroid;

import androidx.viewpager.widget.ViewPager;

import com.zemin.basic_core.adapter.FixedFragmentPagerAdapter;
import com.zemin.basic_core.base.BaseActivity;
import com.zemin.wanandroid.module.main.fragment.MainFragment;
import com.zemin.wanandroid.module.main.presenter.MainPresenter;
import com.zemin.wanandroid.module.main.view.MainView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView,
        ViewPager.OnPageChangeListener {
    private static final String TAG = "MainActivity";

    private static final int PAGE_LIMIT = 1;
    private static final int PAGE_CURRENT = 0;

    private ViewPager contentPager;
    private FixedFragmentPagerAdapter pagerAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView() {
        contentPager = findViewById(R.id.vp_content);
        contentPager.addOnPageChangeListener(this);
        contentPager.setOffscreenPageLimit(PAGE_LIMIT);
        pagerAdapter = new FixedFragmentPagerAdapter(getSupportFragmentManager());
        pagerAdapter.setFragmentList(MainFragment.create());
        contentPager.setAdapter(pagerAdapter);
        contentPager.setCurrentItem(PAGE_CURRENT);
    }

    @Override
    protected void initData() {
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