package com.zemin.basic_ui.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2020/9/23 10:20
 * @Created by zemin
 */
public abstract class BaseQuickAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
    public static final int HEAD_VIEW = 0x00000111;
    public static final int FOOTER_VIEW = 0x00000222;
    public static final int LOADING_VIEW = 0x00000333;
    public static final int EMPTY_VIEW = 0x00000555;

    private int layoutRes;

    protected List<T> data;

    private LinearLayout headerLayout;
    private LinearLayout footerLayout;
    private FrameLayout emptyLayout;

    public BaseQuickAdapter(List<T> data) {
        this(0, data);
    }

    public BaseQuickAdapter(@LayoutRes int layoutRes, List<T> data) {
        this.data = data == null ? new ArrayList<T>() : data;
        if (layoutRes != 0) {
            this.layoutRes = layoutRes;
        }
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BaseViewHolder baseViewHolder;
        switch (viewType) {
            case HEAD_VIEW:
                baseViewHolder = BaseViewHolder.create(headerLayout);
                break;
            case FOOTER_VIEW:
            case LOADING_VIEW:
                baseViewHolder = BaseViewHolder.create(footerLayout);
                break;
            case EMPTY_VIEW:
                baseViewHolder = BaseViewHolder.create(emptyLayout);
                break;
            default:
                baseViewHolder = onCreateDefViewHolder(parent, viewType);
                break;
        }
        return baseViewHolder;
    }

    protected BaseViewHolder onCreateDefViewHolder(@NonNull ViewGroup parent, int viewType) {
        return createBaseViewHolder(parent, layoutRes);
    }

    protected BaseViewHolder createBaseViewHolder(@NonNull ViewGroup parent, int layoutRes) {
        return BaseViewHolder.create(LayoutInflater.from(parent.getContext()).inflate(layoutRes, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        int viewType = holder.getItemViewType();
        switch (viewType) {
            case HEAD_VIEW:
            case FOOTER_VIEW:
            case EMPTY_VIEW:
            case LOADING_VIEW:
                break;
            default:
                convert(holder, getItem(position - getHeaderLayoutCount()));
                break;
        }
    }

    protected abstract void convert(BaseViewHolder holder, T item);

    private T getItem(int position) {
        if (position >= 0 && position < data.size()) {
            return data.get(position);
        }
        return null;
    }

    @Override
    public int getItemCount() {
        if (getEmptyViewCount() == 1) {
            return getEmptyViewCount() + getHeaderLayoutCount() + getFooterLayoutCount();
        }
        return getHeaderLayoutCount() + getFooterLayoutCount() + data.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (getEmptyViewCount() == 1) {
            boolean header = hasHeadLayout();
            switch (position) {
                case 0:
                    return header ? HEAD_VIEW : EMPTY_VIEW;
                case 1:
                    return header ? EMPTY_VIEW : FOOTER_VIEW;
                case 2:
                    return FOOTER_VIEW;
                default:
                    return EMPTY_VIEW;
            }
        }
        int numHeaders = getHeaderLayoutCount();
        if (position < numHeaders) {
            return HEAD_VIEW;
        } else {
            int adjPosition = position - numHeaders;
            int adapterCount = data.size();
            if (adjPosition < adapterCount) {
                return getDefItemViewType(position);
            } else {
                adjPosition = adjPosition - adapterCount;
                int numFooters = getFooterLayoutCount();
                if (adjPosition < numFooters) {
                    return FOOTER_VIEW;
                } else {
                    return LOADING_VIEW;
                }
            }
        }
    }

    protected int getDefItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public int addHeaderView(View header) {
        return addHeaderView(header, -1);
    }

    public int addHeaderView(View header, int index) {
        return addHeaderView(header, index, LinearLayout.VERTICAL);
    }

    public int addHeaderView(View header, int index, int orientation) {
        if (headerLayout == null) {
            headerLayout = new LinearLayout(header.getContext());
            if (orientation == LinearLayout.VERTICAL) {
                headerLayout.setOrientation(LinearLayout.VERTICAL);
                headerLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
            } else {
                headerLayout.setOrientation(LinearLayout.HORIZONTAL);
                headerLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
            }
        }
        final int childCount = headerLayout.getChildCount();
        int mIndex = index;
        if (index < 0 || index > childCount) {
            mIndex = childCount;
        }
        headerLayout.addView(header, mIndex);
        if (hasHeadLayout()) {
            notifyItemInserted(0);
        }
        return mIndex;
    }

    private int getEmptyViewCount() {
        if (emptyLayout == null || emptyLayout.getChildCount() == 0) {
            return 0;
        }
        if (data.size() != 0) {
            return 0;
        }
        return 1;
    }

    private int getFooterLayoutCount() {
        if (footerLayout == null || footerLayout.getChildCount() == 0) {
            return 0;
        }
        return 1;
    }

    private int getHeaderLayoutCount() {
        if (headerLayout == null || headerLayout.getChildCount() == 0) {
            return 0;
        }
        return 1;
    }

    private boolean hasHeadLayout() {
        return headerLayout != null && headerLayout.getChildCount() != 0;
    }
}
