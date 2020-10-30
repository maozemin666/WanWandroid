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
    private int headViewHeight;

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
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = super.getChildCount();
        if (childCount > 3) {
            throw new RuntimeException("最多支持3个子view");
        }
    }

    @Override
    protected void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
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

            if (refreshHeadView != null && refreshHeadView == child) {
                final ViewGroup.LayoutParams lp = child.getLayoutParams();
                MarginLayoutParams mlp = lp instanceof MarginLayoutParams ? (MarginLayoutParams) lp : sDefaultMarginLayoutParams;

                int headWidthMeasureSpec = ViewGroup.getChildMeasureSpec(widthMeasureSpec,
                        paddingStart + paddingEnd + mlp.getMarginStart() + mlp.getMarginEnd(), mlp.width);

                if (lp.height > 0) {
                    headViewHeight = lp.height + mlp.topMargin + mlp.bottomMargin;
                } else if (lp.height == ViewGroup.LayoutParams.WRAP_CONTENT) {
                    final int maxHeight = Math.max(height - mlp.topMargin - mlp.bottomMargin, 0);
                    refreshHeadView.measure(headWidthMeasureSpec, MeasureSpec.makeMeasureSpec(maxHeight, MeasureSpec.AT_MOST));
                    final int measuredHeight = refreshHeadView.getMeasuredHeight();

                    if (measuredHeight > 0) {
                        headViewHeight = measuredHeight;
                    }
                }

                if (lp.height != -1) {
//                    refreshHeadView.measure(headWidthMeasureSpec, );
                }
            }

            final ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
            MarginLayoutParams mlp = layoutParams instanceof MarginLayoutParams ? (MarginLayoutParams) layoutParams : sDefaultMarginLayoutParams;
            int childWidthSize = width - paddingStart - paddingEnd - mlp.getMarginStart() - mlp.getMarginEnd();
            int childWidthSpec = MeasureSpec.makeMeasureSpec(childWidthSize, MeasureSpec.EXACTLY);
            int childHeightSpec = ViewGroup.getChildMeasureSpec(heightMeasureSpec, paddingTop + paddingBottom + mlp.topMargin + mlp.bottomMargin, mlp.height);
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
