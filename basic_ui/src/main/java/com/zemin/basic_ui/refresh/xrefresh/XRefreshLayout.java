package com.zemin.basic_ui.refresh.xrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.zemin.basic_ui.utils.SmartUtil;

public class XRefreshLayout extends LinearLayout {
    protected static final MarginLayoutParams sDefaultMarginLayoutParams = new MarginLayoutParams(-1, -1);

    private XRefreshContentView refreshContentView;
    private XRefreshHeadView refreshHeadView;
    private int touchSlop;
    private int headViewHeight;
    private float lastX;
    private float lastY;
    private float initialMotionY;
    private boolean moveForHorizontal;
    private HeadRefreshState headState = HeadRefreshState.READY_TO_PULL;

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
        refreshContentView.setContentView(getChildAt(1));
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
        int minHeight = 0;

        for (int i = 0; i < childCount; i++) {
            View child = super.getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }

            if (refreshHeadView != null && refreshHeadView == child) {
                final ViewGroup.LayoutParams lp = child.getLayoutParams();
                MarginLayoutParams mlp = lp instanceof MarginLayoutParams ? (MarginLayoutParams) lp : sDefaultMarginLayoutParams;

                int headWidthMeasureSpec = ViewGroup.getChildMeasureSpec(widthMeasureSpec, mlp.leftMargin + mlp.rightMargin, mlp.width);

                if (lp.height > 0) {
                    headViewHeight = lp.height + mlp.topMargin + mlp.bottomMargin;
                } else if (lp.height == ViewGroup.LayoutParams.WRAP_CONTENT) {
                    final int maxHeight = Math.max(height - mlp.topMargin - mlp.bottomMargin, 0);

                    refreshHeadView.measure(headWidthMeasureSpec, MeasureSpec.makeMeasureSpec(maxHeight, MeasureSpec.AT_MOST));

                    final int measuredHeight = refreshHeadView.getMeasuredHeight();
                    if (measuredHeight > 0) {
                        headViewHeight = -1;
                        if (measuredHeight != maxHeight) {
                            headViewHeight = measuredHeight + mlp.topMargin + mlp.bottomMargin;
                        }
                    }
                } else if (lp.height == ViewGroup.LayoutParams.MATCH_PARENT) {
                    headViewHeight = -1;
                }

                if (headViewHeight == -1) {
                    headViewHeight = SmartUtil.dp2px(100);
                }
                refreshHeadView.measure(headWidthMeasureSpec, MeasureSpec.makeMeasureSpec(headViewHeight - mlp.topMargin - mlp.bottomMargin, MeasureSpec.EXACTLY));
                minHeight += refreshHeadView.getMeasuredHeight();
            } else {
                final ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                MarginLayoutParams mlp = layoutParams instanceof MarginLayoutParams ? (MarginLayoutParams) layoutParams : sDefaultMarginLayoutParams;
                int childWidthSize = width - paddingStart - paddingEnd - mlp.getMarginStart() - mlp.getMarginEnd();
                int childWidthSpec = MeasureSpec.makeMeasureSpec(childWidthSize, MeasureSpec.EXACTLY);
                int childHeightSpec = ViewGroup.getChildMeasureSpec(heightMeasureSpec, paddingTop + paddingBottom + mlp.topMargin + mlp.bottomMargin, mlp.height);

                child.measure(childWidthSpec, childHeightSpec);
                minHeight += child.getMeasuredHeight();
            }

        }
        super.setMeasuredDimension(
                View.resolveSize(super.getSuggestedMinimumWidth(), widthMeasureSpec),
                View.resolveSize(minHeight, heightMeasureSpec));
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

            if (refreshHeadView != null && refreshHeadView == child) {
                final ViewGroup.LayoutParams layoutParams = refreshHeadView.getLayoutParams();
                MarginLayoutParams mlp = layoutParams instanceof MarginLayoutParams ? (MarginLayoutParams) layoutParams : sDefaultMarginLayoutParams;
                int left = mlp.leftMargin;
                int right = left + refreshHeadView.getMeasuredWidth();
                int top = mlp.topMargin;
                int bottom = top + refreshHeadView.getMeasuredHeight();
                refreshHeadView.layout(left, top - headViewHeight, right, bottom - headViewHeight);
            } else {
                final ViewGroup.LayoutParams layoutParams = refreshHeadView.getLayoutParams();
                MarginLayoutParams mlp = layoutParams instanceof MarginLayoutParams ? (MarginLayoutParams) layoutParams : sDefaultMarginLayoutParams;
                int left = paddingLeft + mlp.leftMargin;
                int top = paddingTop + mlp.topMargin;
                int right = left + child.getMeasuredWidth();
                int bottom = top + child.getMeasuredHeight();
                child.layout(left, top, right, bottom);
            }
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                lastX = ev.getRawX();
                lastY = ev.getRawY();
                initialMotionY = lastY;
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                float currentX = ev.getRawX();
                float currentY = ev.getRawY();
                float delaX = currentX - lastX;
                float delaY = currentY - lastY;
                lastX = currentX;
                lastY = currentY;

                if (delaX > touchSlop && Math.abs(delaX) > Math.abs(delaY)) {
                    moveForHorizontal = true;
                }

                if (moveForHorizontal) {
                    return super.dispatchTouchEvent(ev);
                }

                if (headState == HeadRefreshState.READY_TO_PULL) {
                    updateHeadView(currentY, delaY);
                }
                break;
            }
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    private void updateHeadView(float currentY, float delaY) {
        moveView(delaY);
    }

    private void moveView(float delaY) {
        refreshHeadView.offsetTopAndBottom((int) delaY);
        refreshContentView.getContentView().offsetTopAndBottom((int) delaY);
    }

    enum HeadRefreshState {
        READY_TO_PULL, LOADING, RELEASE_TO_LOAD_MORE,
    }
}
