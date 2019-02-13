package com.example.marko.ruok;

import android.app.Application;

import com.example.latte.app.Latte;
import com.example.latte.ec.database.DatabaseManager;
import com.example.latte.ec.icon.FontEcModule;
import com.example.latte.net.interceptors.DebugInterceptor;
import com.facebook.stetho.Stetho;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;



/**
 * @author Marko
 * @date 2018/11/14
 */

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://192.168.137.193:8080/untitled_war_exploded/mall/")
                .withInterceptor(new DebugInterceptor("index1", R.raw.test))
                .withWeChatAppId("")
                .withWeChatAppSerect("")
                .configure();
        initStetho();
        //初始化logger
        Logger.addLogAdapter(new AndroidLogAdapter());
        //初始化数据库操作
        DatabaseManager.getInstance().init(this);

    }

    private void initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build()
        );
    }
}
