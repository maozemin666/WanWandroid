package com.zemin.wanandroid.module.main.adapter;

import com.zemin.basic_ui.recyclerview.BaseMultiItemQuickAdapter;
import com.zemin.basic_ui.recyclerview.BaseViewHolder;
import com.zemin.basic_ui.recyclerview.MultiItemEntiy;
import com.zemin.wanandroid.R;

import java.util.List;

/**
 * @Date 2020/9/22 21:43
 * @Created by zemin
 */
public class ArticleAdapter extends BaseMultiItemQuickAdapter<MultiItemEntiy> {
    public ArticleAdapter() {
        super(null);
        addItemType(MultiItemEntiy.ITEM_TYPE_ARTICLE, R.layout.rv_item_article);
    }

    @Override
    protected void convert(BaseViewHolder holder, MultiItemEntiy item) {

    }
}
