package com.zemin.basic_ui.recyclerview;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @Date 2020/9/23 10:24
 * @Created by zemin
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    public static BaseViewHolder create(View view) {
        return new BaseViewHolder(view);
    }

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
