package com.example.latte.app;

import com.example.latte.utils.storage.LattePreference;

/**
 * @author Marko
 * @date 2018/12/13
 * 管理用户信息
 */

public class AccountManager {

    private enum SignTag {
        SING_TAG
    }

    //保存用户登录状态，登录后调用
    public static void setSignState(boolean state) {
        LattePreference.setAppFlag(SignTag.SING_TAG.name(), state);
    }

    //判断是否登录
    private static boolean isSignIn() {
        return LattePreference.getAppFlag(SignTag.SING_TAG.name());
    }

    public static void checkAccount(IUserChecker checker) {
        if (isSignIn()) {
            checker.onSignIn();
        } else {
            checker.onNotSignIn();
        }
    }
}
