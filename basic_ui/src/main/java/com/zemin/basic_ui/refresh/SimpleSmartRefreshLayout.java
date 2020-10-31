package com.zemin.basic_ui.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.zemin.basic_ui.R;

/**
 * @Date 2020/10/21 23:32
 * @Created by zemin
 */
public class SimpleSmartRefreshLayout extends LinearLayout {
    private TextView refreshTextView;

    public SimpleSmartRefreshLayout(Context context) {
        this(context, null);
    }

    public SimpleSmartRefreshLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        View view = LayoutInflater.from(context).inflate(R.layout.simple_layout_to_refresh, this, false);
        refreshTextView = view.findViewById(R.id.tv_refresh);
        addView(view, 0);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

    }
}
