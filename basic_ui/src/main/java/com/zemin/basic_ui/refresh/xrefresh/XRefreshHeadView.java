package com.zemin.basic_ui.refresh.xrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class XRefreshHeadView extends LinearLayout {
    public XRefreshHeadView(Context context) {
        this(context, null);
    }

    public XRefreshHeadView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {

    }
}
