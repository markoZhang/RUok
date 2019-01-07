package com.example.latte.ui.refresh;

import android.support.v4.widget.SwipeRefreshLayout;

import com.example.latte.app.Latte;

/**
 * @author Marko
 * @date 2019/1/7
 */

public class RefreshHandler implements SwipeRefreshLayout.OnRefreshListener {

    private final SwipeRefreshLayout REFRESH_LAYOUT;

    public RefreshHandler(SwipeRefreshLayout refresh_layout) {
        REFRESH_LAYOUT = refresh_layout;
    }

    private void refresh() {
        REFRESH_LAYOUT.setRefreshing(true);
        Latte.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //进行一些网络请求
                REFRESH_LAYOUT.setRefreshing(false);
            }
        }, 2000);
    }

    @Override
    public void onRefresh() {
        refresh();
    }
}
