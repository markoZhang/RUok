package com.example.latte.app;

import android.content.Context;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @author Marko
 * @date 2018/11/14
 * 对外的工具类
 */

public final class Latte {

    public static Configurator init(Context context){
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }
    private static HashMap<String,Object> getConfigurations(){
        return Configurator.getInstance().getLatteConfigs();
    }
    public static Context getApplication(){
        return (Context) getConfigurations().get(ConfigType.APPLICATION_CONTEXT.name());
    }
}
