package com.example.marko.ruok;

import android.app.Application;

import com.example.latte.app.Latte;
import com.example.latte.ec.icon.FontEcModule;
import com.example.latte.net.interceptors.DebugInterceptor;
import com.joanzapata.iconify.fonts.FontAwesomeModule;


/**
 * @author Marko
 * @date 2018/11/14
 */

public class ExampleApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://localhost:8080/untitled_war_exploded/")
                .withInterceptor(new DebugInterceptor("index",R.raw.test))
                .configure();
    }
}
