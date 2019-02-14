package com.example.latte.delegates.web;

/**
 * @author Marko
 * @date 2019/2/12
 */

import android.webkit.JavascriptInterface;

import com.alibaba.fastjson.JSON;
import com.example.latte.delegates.web.event.Event;
import com.example.latte.delegates.web.event.EventManager;

/**
 * 和原生WebView进行交互
 */
public final class LatteWebInterface {

    private final WebDelegate WEB_DELEGATE;

    private LatteWebInterface(WebDelegate webDelegate) {
        WEB_DELEGATE = webDelegate;
    }

    static LatteWebInterface create(WebDelegate delegate){
        return new LatteWebInterface(delegate);
    }

    @SuppressWarnings("unused")
    @JavascriptInterface
    public String event(String params){
        final String action = JSON.parseObject(params).getString("action");
        final Event event = EventManager.getInstance().createEvent(action);
        if (event != null){
            event.setAction(action);
            event.setDelegate(WEB_DELEGATE);
            event.setContext(WEB_DELEGATE.getContext());
            event.setUrl(WEB_DELEGATE.getUrl());
            return event.execute(params);
        }
        return null;
    }

}
