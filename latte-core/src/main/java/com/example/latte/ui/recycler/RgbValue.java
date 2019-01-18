package com.example.latte.ui.recycler;

import com.google.auto.value.AutoValue;

/**
 * @author Marko
 * @date 2019/1/18
 * AutoValue自动生成模块代码
 */

@AutoValue
public abstract class RgbValue {

    public abstract int red();

    public abstract int green();

    public abstract int blue();

    public static RgbValue create(int red,int green,int blue){
        return new AutoValue_RgbValue(red,green,blue);
    }
}
