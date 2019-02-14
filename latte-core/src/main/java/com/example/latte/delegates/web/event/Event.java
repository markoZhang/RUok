package com.example.latte.delegates.web.event;

import android.content.Context;
import android.webkit.WebView;

import com.example.latte.delegates.LatteDelegate;
import com.example.latte.delegates.web.WebDelegate;

/**
 * @author Marko
 * @date 2019/2/13
 */

public abstract class Event implements IEvent {
    private Context context = null;
    private String action = null;
    private WebDelegate delegate = null;
    private String url = null;
    private WebView webView = null;

    public Context getContext() {
        return context;
    }

    public WebView getWebView(){
        return delegate.getWebView();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LatteDelegate getDelegate() {
        return delegate;
    }

    public void setDelegate(WebDelegate delegate) {
        this.delegate = delegate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
