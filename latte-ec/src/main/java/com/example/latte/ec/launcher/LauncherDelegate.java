package com.example.latte.ec.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.example.latte.app.AccountManager;
import com.example.latte.app.IUserChecker;
import com.example.latte.delegates.LatteDelegate;
import com.example.latte.ec.R;
import com.example.latte.ec.R2;
import com.example.latte.ui.launcher.ILauncherListener;
import com.example.latte.ui.launcher.ScrollLauncherTag;
import com.example.latte.ui.launcher.onLauncherFinishTag;
import com.example.latte.utils.storage.LattePreference;
import com.example.latte.utils.timer.BaseTimerTask;
import com.example.latte.utils.timer.ITimerListener;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Marko
 * @date 2018/12/7
 */

public class LauncherDelegate extends LatteDelegate implements ITimerListener {

    @BindView(R2.id.tv_launcher_timer)
    AppCompatTextView mTvTimer = null;

    private Timer mTimer = null;
    private int mCount = 5;
    private ILauncherListener mILauncherListener = null;

    @OnClick(R2.id.tv_launcher_timer)
    void onClickTimerView() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
            checkShowScroll();
        }
    }

    private void initTimer() {
        mTimer = new Timer();
        final BaseTimerTask task = new BaseTimerTask(this);
        /**
         * 第一个参数：要执行的任务
         * 第二个参数：延时0s执行
         * 第三个任务：每隔1s执行一次
         */
        mTimer.schedule(task, 0, 1000);
    }

    //检测是否显示滑动启动页
    private void checkShowScroll() {
        if (!LattePreference.getAppFlag(ScrollLauncherTag.HAS_FIRSTLAUNCHER_APP.name())) {
            getSupportDelegate().start(new LauncherScrollDelegate(), SINGLETASK);
        } else {
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

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ILauncherListener){
            mILauncherListener = (ILauncherListener) activity;
        }
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initTimer();
    }

    @Override
    public void onTimer() {
        getProxyActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mTvTimer != null) {
                    mTvTimer.setText(MessageFormat.format("跳过\n{0}s", mCount));
                    mCount--;
                    if (mCount < 0) {
                        if (mTimer != null) {
                            mTimer.cancel();
                            mTimer = null;
                            checkShowScroll();
                        }
                    }
                }
            }
        });
    }
}
