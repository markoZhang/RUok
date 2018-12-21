package com.example.latte.wechat.template;

import com.example.latte.activities.ProxyActivity;
import com.example.latte.delegates.LatteDelegate;
import com.example.latte.wechat.BaseWXActivity;
import com.example.latte.wechat.BaseWXEntryActivity;
import com.example.latte.wechat.LatteWeChat;

/**
 * @author Marko
 * @date 2018/12/18
 */

public class WXEntryTemplate extends BaseWXEntryActivity {

    /**
     *  登录完成后，微信会返回到以WXEntryTemplate为模板生成的activity
     *  因此我们将此activity的主题设置成透明，并在登录成功后finish掉
     */

    @Override
    protected void onResume() {
        super.onResume();
        finish();
        overridePendingTransition(0,0);
    }

    @Override
    protected void onSignInSuccess(String userInfo) {
        LatteWeChat.getInstance().getSignInCallback().onSignInSuccess(userInfo);
    }
}


