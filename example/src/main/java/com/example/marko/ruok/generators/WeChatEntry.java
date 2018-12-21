package com.example.marko.ruok.generators;

import com.example.latte.wechat.template.WXEntryTemplate;
import com.example.latte_annotations.annotations.EntryGenerator;

/**
 * @author Marko
 * @date 2018/12/18
 */

@EntryGenerator(
        packageName = "com.example.marko.ruok",
        entryTemplate = WXEntryTemplate.class
)
public interface WeChatEntry {
}
