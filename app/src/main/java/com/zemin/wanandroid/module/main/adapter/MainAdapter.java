package com.zemin.wanandroid.module.main.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.zemin.basic_core.adapter.tab.TabAdapter;
import com.zemin.wanandroid.R;
import com.zemin.wanandroid.module.main.model.TabEntity;

/**
 * @Date 2020/11/18 22:41
 * @Created by zemin
 */
public class MainAdapter implements TabAdapter<TabEntity> {
    @Override
    public void onBindData(View view, TabEntity data, boolean selected) {
        Context context = view.getContext();
        ImageView tabIcon = view.findViewById(R.id.iv_tab_icon);
        TextView tabName = view.findViewById(R.id.tv_tab_name);
        TextView tabMsg = view.findViewById(R.id.tv_tab_msg);
        tabIcon.setImageResource(data.getTabIcon());
        tabName.setText(data.getTabName());
        if (selected) {
            tabIcon.setColorFilter(ContextCompat.getColor(context, R.color.main));
            tabName.setTextColor(ContextCompat.getColor(context, R.color.main));
        } else {
            tabIcon.setColorFilter(ContextCompat.getColor(context, R.color.third));
            tabName.setTextColor(ContextCompat.getColor(context, R.color.third));
        }
        if (data.getMsgCount() > 0) {
            tabMsg.setVisibility(View.VISIBLE);
            if (data.getMsgCount() > 99) {
                tabMsg.setText("99+");
            } else {
                tabMsg.setText(data.getMsgCount() + "");
            }
        } else {
            tabMsg.setVisibility(View.GONE);
        }
    }

    @Override
    public void onDoubleTap(Fragment fragment) {

    }
}
