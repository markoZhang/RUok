package com.example.latte.ec.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.example.latte.app.AccountManager;
import com.example.latte.app.IUserChecker;
import com.example.latte.delegates.LatteDelegate;
import com.example.latte.ec.R;
import com.example.latte.ui.launcher.ILauncherListener;
import com.example.latte.ui.launcher.LauncherHolderCreator;
import com.example.latte.ui.launcher.ScrollLauncherTag;
import com.example.latte.ui.launcher.onLauncherFinishTag;
import com.example.latte.utils.storage.LattePreference;

import java.util.ArrayList;

/**
 * @author Marko
 * @date 2018/12/7
 */

public class LauncherScrollDelegate extends LatteDelegate implements OnItemClickListener {

    //我们传入的是资源文件，所以泛型类型设置为Integer
    private ConvenientBanner<Integer> mConvenientBanner = null;
    private static final ArrayList<Integer> INTEGERS = new ArrayList<>();
    private ILauncherListener mILauncherListener = null;

    private void initBanner() {
        INTEGERS.add(R.mipmap.launcher_01);
        INTEGERS.add(R.mipmap.launcher_02);
        INTEGERS.add(R.mipmap.launcher_03);
        INTEGERS.add(R.mipmap.launcher_04);
        INTEGERS.add(R.mipmap.launcher_05);
        mConvenientBanner.setPages(new LauncherHolderCreator(), INTEGERS)
                //设置轮播图下方的圆点
                .setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_focus})
                //设置圆点的位置
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(this)
                //设置可循环
                .setCanLoop(false);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ILauncherListener){
            mILauncherListener = (ILauncherListener) activity;
        }
    }

    @Override
    public Object setLayout() {
        mConvenientBanner = new ConvenientBanner<>(getContext());
        return mConvenientBanner;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initBanner();
    }

    @Override
    public void onItemClick(int position) {
        //如果点击的是最后一张图片
        if (position == INTEGERS.size() - 1) {
            LattePreference.setAppFlag(ScrollLauncherTag.HAS_FIRSTLAUNCHER_APP.name(), true);
            //检查用户是否已经登录
            AccountManager.checkAccount(new IUserChecker() {
                @Override
                public void onSignIn() {
                    mILauncherListener.onLauncherFinish(onLauncherFinishTag.SIGNED);
                }

                @Override
                public void onNotSignIn() {
                    mILauncherListener.onLauncherFinish(onLauncherFinishTag.NOT_SIGNED);
                }
            });
        }

    }
}
