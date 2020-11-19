package com.zemin.basic_core.utils;

import com.scwang.smartrefresh.layout.api.RefreshLayout;

/**
 * @Date 2020/11/19 20:57
 * @Author by zemin
 */
public class SmartRefreshUtils {
    private final RefreshLayout refreshLayout;

    public static SmartRefreshUtils with(RefreshLayout refreshLayout) {
        return new SmartRefreshUtils(refreshLayout);
    }

    private SmartRefreshUtils(RefreshLayout refreshLayout) {
        this.refreshLayout = refreshLayout;
    }

    public SmartRefreshUtils pureScrollMode() {
        refreshLayout.setEnableLoadMore(false);
        refreshLayout.setEnableRefresh(false);
        refreshLayout.setEnablePureScrollMode(true);
        refreshLayout.setEnableNestedScroll(true);
        refreshLayout.setEnableOverScrollDrag(true);
        return this;
    }

    public SmartRefreshUtils setRefreshListener(RefreshListener refreshListener) {
        if (refreshListener == null) {
            refreshLayout.setEnableRefresh(false);
        } else {
            refreshLayout.setEnableRefresh(true);
            refreshLayout.setEnablePureScrollMode(false);
            refreshLayout.setOnRefreshListener(rfl -> {
                refreshListener.onRefresh();
            });
        }
        return this;
    }

    public interface RefreshListener {
        void onRefresh();
    }
}
