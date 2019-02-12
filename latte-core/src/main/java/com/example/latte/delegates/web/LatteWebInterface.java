package com.example.latte.delegates.web;

/**
 * @author Marko
 * @date 2019/2/12
 */

import com.alibaba.fastjson.JSON;

/**
 * 和原生WebView进行交互
 */
public class LatteWebInterface {

    private final WebDelegate WEB_DELEGATE;

    private LatteWebInterface(WebDelegate webDelegate) {
        WEB_DELEGATE = webDelegate;
    }

    static LatteWebInterface create(WebDelegate delegate){
        return new LatteWebInterface(delegate);
    }

    public String event(String params){
        final String action = JSON.parseObject(params).getString("action");
        return null;
    }

}
