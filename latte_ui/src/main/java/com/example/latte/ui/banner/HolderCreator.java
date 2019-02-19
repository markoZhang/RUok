package com.example.latte.ui.banner;

import android.view.View;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.example.latte.R;

/**
 * @author Marko
 * @date 2019/1/16
 */

public class HolderCreator implements CBViewHolderCreator{

    @Override
    public Holder createHolder(View itemView) {
        return new ImageHolder(itemView);
    }

    @Override
    public int getLayoutId() {
        return R.layout.banner_item;
    }
}
