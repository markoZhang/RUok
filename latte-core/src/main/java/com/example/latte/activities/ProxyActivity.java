package com.example.latte.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;

import com.example.latte.R;
import com.example.latte.delegates.LatteDelegate;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * @author Marko
 * @date 2018/11/20
 */

public abstract class ProxyActivity extends SupportActivity{

    //返回根delegate
    public abstract LatteDelegate setRootDelegate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }

    /**
     * 传入根delegate
     * @param savedInstanceState
     */
    private void initContainer(@Nullable Bundle savedInstanceState){
        //ContentFrameLayout是V7包中的容纳Fragment的容器
        final ContentFrameLayout container = new ContentFrameLayout(this);
        container.setId(R.id.delegate_container);
        setContentView(container);
        if (savedInstanceState == null){
            loadRootFragment(R.id.delegate_container,setRootDelegate());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * 由于是单Activity架构
         * 当前Activity退出后，整个应用就退出了，所以做垃圾回收的操作
         */
        System.gc();
        System.runFinalization();
    }
}
