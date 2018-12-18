package com.example.marko.ruok.generators;

import com.example.latte.activities.ProxyActivity;
import com.example.latte.wechat.template.WXPayEntryTemplate;
import com.example.latte_annotations.annotations.PayEntryGenerator;

/**
 * @author Marko
 * @date 2018/12/18
 */

@PayEntryGenerator(
        packageName = "com.example.marko.ruok",
        payEntryTemplate = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
