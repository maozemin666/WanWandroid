package com.zemin.basic_core.adapter.tab;

import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * @Date 2020/11/15 17:49
 * @Created by zemin
 */
public class TabGestureDetectorListener implements GestureDetector.OnGestureListener {

    private final Page page;
    private final TabFragmentPagerAdapter adapter;

    public TabGestureDetectorListener(TabFragmentPagerAdapter adapter, Page page) {
        this.adapter = adapter;
        this.page = page;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        adapter.switchCurrentItem(page);
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}
