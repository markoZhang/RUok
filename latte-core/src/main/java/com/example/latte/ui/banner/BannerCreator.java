package com.example.latte.ui.banner;

import android.widget.AdapterView;

import com.ToxicBakery.viewpager.transforms.DefaultTransformer;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.example.latte.R;

import java.util.ArrayList;

/**
 * @author Marko
 * @date 2019/1/16
 */

public class BannerCreator {
    public static void setDefault(ConvenientBanner<String> convenientBanner,
                                  ArrayList<String> banners,
                                  OnItemClickListener clickListener) {
        convenientBanner.setPages(new HolderCreator(), banners)
                //设置两个点图片作为翻页指示器，不设置则没有指示器
                .setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_focus})
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(clickListener)
                .setPageTransformer(new DefaultTransformer())
                .startTurning(3000)
                .setCanLoop(true);

    }
}
