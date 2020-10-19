package com.zemin.wanandroid.module.home.Banner;

import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.zemin.basic_ui.banner.BannerImageAdapter;
import com.zemin.basic_ui.banner.BannerImageViewHolder;
import com.zemin.wanandroid.R;
import com.zemin.wanandroid.module.home.model.BannerBean;

/**
 * @Date 2020/9/24 9:53
 * @Created by zemin
 */
public class BannerHeaderAdapter extends BannerImageAdapter<BannerBean> {
    private static final String TAG = "BannerHeaderAdapter";

    public BannerHeaderAdapter() {
        super(null);
    }

    @Override
    public void onBindView(BannerImageViewHolder holder, BannerBean data) {
        Log.d(TAG, "onBindView: data = " + data);
        ImageView imageView = holder.imageView;
        if (imageView != null && data != null
                && !TextUtils.isEmpty(data.getUrl())) {
            Glide.with(imageView.getContext())
                    .load(data.getImagePath())
                    .error(R.drawable.image_holder)
                    .placeholder(R.drawable.image_holder)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                    .into(imageView);
        }
    }
}
