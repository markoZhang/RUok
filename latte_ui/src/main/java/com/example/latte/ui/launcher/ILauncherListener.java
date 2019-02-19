package com.example.latte.ui.launcher;

/**
 * @author Marko
 * @date 2018/12/13
 */

public interface ILauncherListener {
    /**
     * @param tag 区分是登录成功的finish还是登录不成功的finish
     */
    void onLauncherFinish(onLauncherFinishTag tag);
}

