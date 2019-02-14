package com.example.latte.delegates.web.client;

import android.graphics.Bitmap;
import android.os.Handler;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.latte.app.ConfigKeys;
import com.example.latte.app.Latte;
import com.example.latte.delegates.IPageLoadListener;
import com.example.latte.delegates.web.WebDelegate;
import com.example.latte.delegates.web.route.Router;
import com.example.latte.ui.loader.LatteLoader;
import com.example.latte.utils.log.LatteLogger;
import com.example.latte.utils.storage.LattePreference;


/**
 * @author Marko
 * @date 2019/2/13
 */

public class WebViewClientImpl extends WebViewClient {

    private final WebDelegate delegate;
    private IPageLoadListener mIPageLoadListener = null;
    private static final Handler HANDLER = Latte.getHandler();

    public void setPageLoadListener(IPageLoadListener pageLoadListener) {
        this.mIPageLoadListener = pageLoadListener;
    }

    public WebViewClientImpl(WebDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        LatteLogger.d("shouldOverrideUrlLoading", url);
        return Router.getInstance().handlerWebUrl(delegate, url);
    }

    //获取浏览器Cookie
    private void syncCookie() {
        final CookieManager manager = CookieManager.getInstance();
        /**
         * 注意，这里的Cookie和API请求的Cookie是不一样的，这个再网页中不可见
         */
        final String webHost = Latte.getConfiguration(ConfigKeys.WEB_HOST);
        if (webHost != null) {
            if (manager.hasCookies()) {
                final String cookieStr = manager.getCookie(webHost);
                if (cookieStr != null && !cookieStr.equals("")) {
                    LattePreference.addCustomAppProfile("cookie", cookieStr);
                }
            }
        }
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        if (mIPageLoadListener != null) {
            mIPageLoadListener.onLoadStart();
        }
        LatteLoader.showLoading(view.getContext());
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        syncCookie();
        if (mIPageLoadListener != null) {
            mIPageLoadListener.onLoadEnd();
        }
        HANDLER.postDelayed(new Runnable() {
            @Override
            public void run() {
                LatteLoader.stopLoading();
            }
        }, 1000);
    }
}
