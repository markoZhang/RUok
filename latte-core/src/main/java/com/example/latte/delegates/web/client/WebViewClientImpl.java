package com.example.latte.delegates.web.client;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.latte.delegates.web.WebDelegate;
import com.example.latte.delegates.web.route.Router;
import com.example.latte.utils.log.LatteLogger;

/**
 * @author Marko
 * @date 2019/2/13
 */

public class WebViewClientImpl extends WebViewClient {

    private final WebDelegate delegate;

    public WebViewClientImpl(WebDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        LatteLogger.d("shouldOverrideUrlLoading", url);
        return Router.getInstance().handlerWebUrl(delegate,url);
    }
}
