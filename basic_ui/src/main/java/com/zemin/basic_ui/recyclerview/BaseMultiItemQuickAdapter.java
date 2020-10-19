package com.zemin.basic_ui.recyclerview;

import android.util.SparseIntArray;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import java.util.List;

/**
 * @Date 2020/9/23 19:13
 * @Created by zemin
 */
public abstract class BaseMultiItemQuickAdapter<T extends MultiItemEntiy> extends BaseQuickAdapter<T> {
    private static final int DEFAULT_VIEW_TYPE = -0xff;
    private static final int TYPE_NOT_FOUND = -404;

    private SparseIntArray layouts;

    public BaseMultiItemQuickAdapter(List<T> data) {
        super(data);
    }

    protected void addItemType(int type, @LayoutRes int layoutId) {
        if (layouts == null) {
            layouts = new SparseIntArray();
        }
        layouts.put(type, layoutId);
    }

    @Override
    protected BaseViewHolder onCreateDefViewHolder(@NonNull ViewGroup parent, int viewType) {
        return createBaseViewHolder(parent, getLayoutId(viewType));
    }

    private int getLayoutId(int viewType) {
        return layouts.get(viewType, TYPE_NOT_FOUND);
    }

    @Override
    protected int getDefItemViewType(int position) {
        MultiItemEntiy multiItemEntiy = data.get(position);
        if (multiItemEntiy != null) {
            return multiItemEntiy.getItemViewType();
        }
        return DEFAULT_VIEW_TYPE;
    }
}
