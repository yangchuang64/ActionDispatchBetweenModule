package com.module.action.dispatch;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.module.action.dispatch.lib.DispatchAction;
import com.module.action.dispatch.lib.DispatchManager;
import com.module.action.dispatch.lib.IDispatchListener;
import com.module.action.dispatch.module1.AModuleActivity;
import com.module.action.dispatch.module2.BModuleActivity;

/**
 * Created by yangtianfei on 17/4/4.
 */

public class MApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DispatchManager dispatchManager = DispatchManager.getInstance();
        // 从A module跳转到B module
        dispatchManager.addDispatchListener(new IDispatchListener() {
            @Override
            public Intent dispatchAction(String action, Context context, Bundle bundle) {
                if (action.equals(DispatchAction.JUMP_TO_B))
                    return new Intent(context, BModuleActivity.class);
                return null;
            }
        });
        // 从B module跳转到A module
        dispatchManager.addDispatchListener(new IDispatchListener() {
            @Override
            public Intent dispatchAction(String action, Context context, Bundle bundle) {
                if (action.equals(DispatchAction.JUMP_TO_A))
                    return new Intent(context, AModuleActivity.class);
                return null;
            }
        });
    }
}
