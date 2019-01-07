package com.example.latte.ec.main.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.latte.delegates.bottom.BottomItemDelegate;
import com.example.latte.ec.R;

/**
 * @author Marko
 * @date 2019/1/5
 */

public class IndexDelegate extends BottomItemDelegate{

    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
