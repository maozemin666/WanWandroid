package com.zemin.wanandroid.module.home.fragment;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zemin.basic_core.base.BaseFragment;
import com.zemin.basic_core.utils.SmartRefreshUtils;
import com.zemin.basic_ui.banner.Banner;
import com.zemin.wanandroid.R;
import com.zemin.wanandroid.module.home.Banner.BannerHeaderAdapter;
import com.zemin.wanandroid.module.home.model.BannerBean;
import com.zemin.wanandroid.module.home.presenter.HomePresenter;
import com.zemin.wanandroid.module.home.view.HomeView;
import com.zemin.wanandroid.module.main.adapter.ArticleAdapter;

import java.util.List;

/**
 * @Date 2020/9/22 18:09
 * @Author  by zemin
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements HomeView {
    private static final String TAG = "HomeFragment";
    private static final int PAGE_START = 0;

    private RecyclerView home;
    private SmartRefreshLayout refresh;
    private SmartRefreshUtils refreshUtils;

    private ArticleAdapter articleAdapter;

    private Banner<BannerHeaderAdapter> banner;
    private BannerHeaderAdapter bannerAdapter;

    private int currentPage = PAGE_START;

    public static HomeFragment create() {
        return new HomeFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {
        refresh = findViewById(R.id.srl_refresh);
        refreshUtils = SmartRefreshUtils.with(refresh);
        refreshUtils.pureScrollMode();
        refreshUtils.setRefreshListener(this::refresh);

        home = findViewById(R.id.rv_home);
        home.setLayoutManager(new LinearLayoutManager(getContext()));
        articleAdapter = new ArticleAdapter();
        home.setAdapter(articleAdapter);

        createBanner();
    }

    private void refresh() {

    }

    private void createBanner() {
        Context context = getContext();
        if (banner == null && context != null) {
            banner = new Banner<>(context);
            banner.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 550));
            bannerAdapter = new BannerHeaderAdapter();
            bannerAdapter.setOnBannerListener((data, position) -> {

            });
            banner.setAdapter(bannerAdapter);
            articleAdapter.addHeaderView(banner, 0);
        }
    }

    @Override
    protected void loadData() {
        presenter.getBanner();
        presenter.getTopArticleList();
        presenter.getArticleList(currentPage);
    }

    @Override
    public void onStart() {
        super.onStart();
        banner.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.stop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        banner.destroy();
    }

    @Override
    public void getBannerSuccess(int code, List<BannerBean> data) {
        Log.d(TAG, "getBannerSuccess: ");
        bannerAdapter.setDatas(data);
        bannerAdapter.notifyDataSetChanged();
    }

    @Override
    public void getBannerFail(int code, String msg) {
        Log.d(TAG, "getBannerFail: code=" + code);
    }
}
