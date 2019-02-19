package com.example.latte.ui.launcher;

import android.view.View;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.example.latte.R;

/**
 * @author Marko
 * @date 2018/12/7
 */

public class LauncherHolderCreator implements CBViewHolderCreator{

    @Override
    public Holder createHolder(View itemView) {
        return new LauncherHolder(itemView);
    }

    @Override
    public int getLayoutId() {
        return R.layout.banner_item;
    }
}
