package com.zemin.basic_ui.refresh.xrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class XRefreshLayout extends LinearLayout {
    protected static final MarginLayoutParams sDefaultMarginLayoutParams = new MarginLayoutParams(-1, -1);

    private XRefreshContentView refreshContentView;
    private XRefreshHeadView refreshHeadView;
    private int touchSlop;

    public XRefreshLayout(Context context) {
        this(context, null);
    }

    public XRefreshLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        setOrientation(VERTICAL);
        touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();

        refreshContentView = new XRefreshContentView();
        refreshHeadView = new XRefreshHeadView(context);
        addView(refreshHeadView, 0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        final int childCount = super.getChildCount();
        final int paddingStart = super.getPaddingStart();
        final int paddingEnd = super.getPaddingEnd();
        final int paddingTop = super.getPaddingTop();
        final int paddingBottom = super.getPaddingBottom();

        for (int i = 0; i < childCount; i++) {
            View child = super.getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }
            final ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
            MarginLayoutParams mlp = layoutParams instanceof MarginLayoutParams ? (MarginLayoutParams) layoutParams : sDefaultMarginLayoutParams;
            int childWidthSize = width - paddingStart - paddingEnd - mlp.getMarginStart() - mlp.getMarginEnd();

            int childWidthSpec = MeasureSpec.makeMeasureSpec(childWidthSize, MeasureSpec.EXACTLY);
            int childHeightSpec = super.getChildMeasureSpec(height, paddingTop + paddingBottom + mlp.topMargin + mlp.bottomMargin, mlp.height);
            child.measure(childWidthSpec, childHeightSpec);
        }
        super.setMeasuredDimension(
                View.resolveSize(super.getSuggestedMinimumWidth(), widthMeasureSpec),
                height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final View thisView = this;
        final int paddingLeft = thisView.getPaddingLeft();
        final int paddingTop = thisView.getPaddingTop();
        final int paddingBottom = thisView.getPaddingBottom();

        for (int i = 0, len = super.getChildCount(); i < len; i++) {
            View child = super.getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }

            final ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
            MarginLayoutParams mlp = layoutParams instanceof MarginLayoutParams ? (MarginLayoutParams) layoutParams : sDefaultMarginLayoutParams;

            int left = paddingLeft + mlp.leftMargin;
            int top = paddingTop + mlp.topMargin;
            int right = left + child.getMeasuredWidth();
            int bottom = top + child.getMeasuredHeight();
            child.layout(left, top, right, bottom);
        }
    }
}
}
