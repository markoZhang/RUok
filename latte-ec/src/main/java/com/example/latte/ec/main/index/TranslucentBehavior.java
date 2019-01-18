package com.example.latte.ec.main.index;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

import com.example.latte.ec.R;
import com.example.latte.ui.recycler.RgbValue;

/**
 * @author Marko
 * @date 2019/1/18
 */

/**
 * 注意要在布局文件中的toolbar中设置Behavior属性
 */
@SuppressWarnings("unused")
public class TranslucentBehavior extends CoordinatorLayout.Behavior<Toolbar> {

    //顶部距离
    private int mDistanceY = 0;
    //颜色变化速率
    private  final int SHOW_SPEED = 3;
    //定义变化的颜色
    private final RgbValue rgbValue = RgbValue.create(255, 124, 2);

    //注意选择有两个参数的构造方法，否则会报错
    public TranslucentBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Toolbar child, View dependency) {
        //由于我们的状态栏是根据RecyclerView来变化的，所以我们返回RecyclerView的id
        return dependency.getId() == R.id.rv_index;
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Toolbar child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return true;
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Toolbar child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
        //增加滑动距离
        mDistanceY += dy;
        //获取ToolBar的高度
        final int targetHeight = child.getBottom();
        //当滑动时，并且距离小于 toolbar 高度的时候，调整渐变色
        if (mDistanceY > 0 && mDistanceY <= targetHeight) {
            final float scale = (float) mDistanceY / targetHeight;
            final float alpha = scale * 255;
            child.setBackgroundColor(Color.argb((int) alpha, rgbValue.red(), rgbValue.green(), rgbValue.blue()));
        } else if (mDistanceY > targetHeight) {
            child.setBackgroundColor(Color.rgb(rgbValue.red(), rgbValue.green(), rgbValue.blue()));
        }
    }
}
