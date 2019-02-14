package com.example.latte.delegates.web;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.latte.delegates.IPageLoadListener;
import com.example.latte.delegates.web.client.WebChromeClientImpl;
import com.example.latte.delegates.web.client.WebViewClientImpl;
import com.example.latte.delegates.web.route.RouteKeys;
import com.example.latte.delegates.web.route.Router;

/**
 * @author Marko
 * @date 2019/2/12
 */

public class WebDelegateImpl extends WebDelegate {

    private IPageLoadListener mIPageLoadListener = null;

    public static WebDelegateImpl create(String url){
        final Bundle args = new Bundle();
        args.putString(RouteKeys.URL.name(),url);
        final WebDelegateImpl delegate = new WebDelegateImpl();
        delegate.setArguments(args);
        return delegate;
    }

    public void setPageLoadListener(IPageLoadListener listener) {
        this.mIPageLoadListener = listener;
    }

    @Override
    public Object setLayout() {
        return getWebView();
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        if (getUrl()!=null){
            //用原生的方式模拟web跳转并进行页面加载
            Router.getInstance().loadPage(this,getUrl());
        }
    }

    @Override
    public IWebViewInitializer setInitializer() {
        //返回接口实现对象
        return this;
    }

    @Override
    public WebView initWebView(WebView webView) {
        //初始化WebView，做出相应的设置
        return new WebViewInitializer().createWebView(webView);
    }

    @Override
    public WebViewClient initWebViewClient() {
        final WebViewClientImpl client = new WebViewClientImpl(this);
        client.setPageLoadListener(mIPageLoadListener);
        return client;
    }

    @Override
    public WebChromeClient initWebChromeClient() {
        //辅助WebView处理JavaScript的对话框、网站图标、网站title、加载进度等
        return new WebChromeClientImpl();
    }
}
