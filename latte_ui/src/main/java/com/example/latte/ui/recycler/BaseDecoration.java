package com.example.latte.ui.recycler;

import android.support.annotation.ColorInt;

import com.choices.divider.DividerItemDecoration;

/**
 * @author Marko
 * @date 2019/1/18
 * 添加RecyclerView的分割线
 */

public class BaseDecoration extends DividerItemDecoration {

    /**
     * @param color 分割线的颜色
     * @param size  分割线的大小
     */
    private BaseDecoration(@ColorInt int color, int size) {
        setDividerLookup(new DividerLookupImpl(color,size));
    }

    public static BaseDecoration create(@ColorInt int color, int size){
        return new BaseDecoration(color,size);
    }
}
