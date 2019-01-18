package com.example.latte.delegates;

/**
 * @author Marko
 * @date 2018/11/20
 */

public abstract class LatteDelegate extends PermissionCheckerDelegate{

    @SuppressWarnings("unchecked")
    public <T extends LatteDelegate> T getParentDelegate(){
        return (T) getParentFragment();
    }
}
