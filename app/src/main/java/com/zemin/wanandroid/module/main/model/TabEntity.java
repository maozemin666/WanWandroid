package com.zemin.wanandroid.module.main.model;

import com.zemin.basic_core.adapter.tab.TabItem;

/**
 * @Date 2020/11/15 17:31
 * @Created by zemin
 */
public class TabEntity implements TabItem {
    private String tabName;

    private int tabIcon;

    private int msgCount;

    private int layoutId;

    public TabEntity(String tabName, int tabIcon, int layoutId) {
        this.tabName = tabName;
        this.tabIcon = tabIcon;
        this.layoutId = layoutId;
    }

    @Override
    public int getLayoutId() {
        return layoutId;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public void setTabIcon(int tabIcon) {
        this.tabIcon = tabIcon;
    }

    public int getMsgCount() {
        return msgCount;
    }

    public void setMsgCount(int msgCount) {
        this.msgCount = msgCount;
    }

    public String getTabName() {
        return tabName;
    }

    public int getTabIcon() {
        return tabIcon;
    }
}
