package com.example.latte.ec.main.index;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.example.latte.delegates.LatteDelegate;
import com.example.latte.ec.detail.GoodsDetailDelegate;

/**
 * @author Marko
 * @date 2019/1/18
 */

public class IndexItemClickListener extends SimpleClickListener{

    private final LatteDelegate DELEGATE;

    private IndexItemClickListener(LatteDelegate latteDelegate) {
        this.DELEGATE = latteDelegate;
    }

    public static SimpleClickListener create(LatteDelegate delegate){
        return new IndexItemClickListener(delegate);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        DELEGATE.start(GoodsDetailDelegate.ceate());
    }

    @Override
    public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
