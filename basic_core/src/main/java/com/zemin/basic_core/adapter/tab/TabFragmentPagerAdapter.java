package com.zemin.basic_core.adapter.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

/**
 * @Date 2020/11/15 17:02
 * @Created by zemin
 */
public class TabFragmentPagerAdapter<T extends TabItem> extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener{
    private final ViewPager viewPager;
    private final LinearLayout tabContainer;
    private Page<T>[] pages;

    public TabFragmentPagerAdapter(@NonNull FragmentManager fm,
                                   @NonNull ViewPager viewPager,
                                   @NonNull LinearLayout tabContainer) {
        super(fm);
        this.viewPager = viewPager;
        this.tabContainer = tabContainer;

        viewPager.addOnPageChangeListener(this);
    }

    @SafeVarargs
    public final void setPages(Page<T>... pages) {
        tabContainer.removeAllViews();
        this.pages = pages;
        viewPager.setOffscreenPageLimit(pages.length);
        for (Page<T> page : pages) {
            initPageTab(page);
        }
        notifyDataSetChanged();
    }

    private void initPageTab(Page<T> page) {
        int tabItemLayoutId = page.getData().getLayoutId();
        if (tabItemLayoutId == 0) {
            return;
        }

        final Context context = viewPager.getContext();
        final View pageItemView = LayoutInflater.from(context).inflate(tabItemLayoutId, tabContainer, false);
        final LinearLayout.LayoutParams itemParams = (LinearLayout.LayoutParams) pageItemView.getLayoutParams();
        itemParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
        itemParams.width = 0;
        itemParams.weight = 1;

        page.setView(pageItemView);
        tabContainer.addView(pageItemView, itemParams);

        initPagTabTouchEvent(page, context, pageItemView);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initPagTabTouchEvent(Page<T> page, Context context, View pageItemView) {
        final GestureDetector tabGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                return true;
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                switchCurrentItem(page);
                return true;
            }
        });
        tabGestureDetector.setOnDoubleTapListener(new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                page.notifyAdapterDoubleTap();
                return true;
            }
        });
        pageItemView.setOnTouchListener((v, ev) -> tabGestureDetector.onTouchEvent(ev));
    }

    public void switchCurrentItem(Page page) {
        for (int i = 0; i < getCount(); i++) {
            Fragment fragment = getItem(i);
            if (page.getFragment() == fragment) {
                viewPager.setCurrentItem(i);
                break;
            }
        }
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        notifyPageDataSetChanged(viewPager.getCurrentItem());
    }

    private void notifyPageDataSetChanged(int currentItem) {
        for (int i = 0; i < pages.length; i++) {
            pages[i].notifyAdapterBindData(currentItem == i);
        }
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return pages[position].getFragment();
    }

    @Override
    public int getCount() {
        return pages == null ? 0 : pages.length;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        notifyPageDataSetChanged(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
