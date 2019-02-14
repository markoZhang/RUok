package com.example.latte.app;

import android.app.Activity;
import android.os.Handler;
import android.support.annotation.NonNull;

import com.example.latte.delegates.web.event.Event;
import com.example.latte.delegates.web.event.EventManager;
import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Interceptor;


/**
 * @author Marko
 * @date 2018/11/14
 */

public class Configurator {

    private static final HashMap<Object, Object> LATTE_CONFIGS = new HashMap<>();

    private static final Handler HANDLER = new Handler();

    //存储字体图标
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();

    private static final ArrayList<Interceptor> INTERCEPTORS = new ArrayList<>();

    private Configurator() {
        LATTE_CONFIGS.put(ConfigKeys.API_HOST.name(), false);
        LATTE_CONFIGS.put(ConfigKeys.HANDLER,HANDLER);
    }

    /**
     * 静态内部类实现的懒汉式的单例模式
     */
    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    final HashMap<Object, Object> getLatteConfigs() {
        return LATTE_CONFIGS;
    }

    public final void configure() {
        initIcons();
        LATTE_CONFIGS.put(ConfigKeys.CONFIG_READY.name(), true);
    }

    public final Configurator withApiHost(String host) {
        LATTE_CONFIGS.put(ConfigKeys.API_HOST, host);
        return this;
    }

    /**
     * 初始化字体图标
     */
    private void initIcons() {
        if (ICONS.size() > 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    public final Configurator withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;
    }

    public final Configurator withInterceptor(Interceptor interceptor) {
        INTERCEPTORS.add(interceptor);
        LATTE_CONFIGS.put(ConfigKeys.INTERCEPTOR, INTERCEPTORS);
        return this;
    }

    public final Configurator withInterceptors(ArrayList<Interceptor> interceptors) {
        INTERCEPTORS.addAll(interceptors);
        LATTE_CONFIGS.put(ConfigKeys.INTERCEPTOR, INTERCEPTORS);
        return this;
    }

    public final Configurator withWeChatAppId(String appId) {
        LATTE_CONFIGS.put(ConfigKeys.WE_CHAT_APP_ID, appId);
        return this;
    }

    public final Configurator withWeChatAppSerect(String appSerect) {
        LATTE_CONFIGS.put(ConfigKeys.WE_CHAT_APP_SECRET, appSerect);
        return this;
    }

    public final Configurator withActivity(Activity activity) {
        LATTE_CONFIGS.put(ConfigKeys.ACTIVITY, activity);
        return this;
    }

    public Configurator withJavascriptInterface(@NonNull String name) {
        LATTE_CONFIGS.put(ConfigKeys.JAVASCRIPT_INTERFACE, name);
        return this;
    }

    public Configurator withWebEvent(@NonNull String name, @NonNull Event event) {
        final EventManager manager = EventManager.getInstance();
        manager.addEvent(name, event);
        return this;
    }

    /**
     * 传入浏览器host
     */
    public final Configurator withWebHost(String host) {
        LATTE_CONFIGS.put(ConfigKeys.WEB_HOST, host);
        return this;
    }

    /**
     * 检查配置是否完成，未完成则抛出运行时异常
     */
    private void checkConfiguration() {
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigKeys.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Object key) {
        checkConfiguration();
        final Object value = LATTE_CONFIGS.get(key);
        if (value == null) {
            throw new NullPointerException(key.toString() + "Is Null");
        }
        return (T) LATTE_CONFIGS.get(key);
    }
}
