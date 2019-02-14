package com.example.latte.delegates.web.event;

import com.example.latte.utils.log.LatteLogger;

/**
 * @author Marko
 * @date 2019/2/13
 */

public class UndefineEvent extends Event {
    @Override
    public String execute(String params) {
        LatteLogger.e("UndefineEvent",params);
        return null;
    }
}
