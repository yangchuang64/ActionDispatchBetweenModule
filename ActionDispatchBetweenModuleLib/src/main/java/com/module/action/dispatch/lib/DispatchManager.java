package com.module.action.dispatch.lib;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangtianfei on 16/1/4.
 */
public class DispatchManager {

    private volatile static DispatchManager mInstance;

    private List<IDispatchListener> mDispatchListeners;

    private DispatchManager() {
        mDispatchListeners = new ArrayList();
    }

    /**
     * Returns singleton class instance
     */
    public static DispatchManager getInstance() {
        if (mInstance == null) {
            synchronized (DispatchManager.class) {
                if (mInstance == null) {
                    mInstance = new DispatchManager();
                }
            }
        }
        return mInstance;
    }

    public void addDispatchListener(IDispatchListener listener) {
        if (listener == null) return;
        mDispatchListeners.add(listener);
    }

    public void dispatchEvent(String action, Context context, Bundle bundle, IJumpCallBack callBack) {
        Intent intent = null;

        for (IDispatchListener listener : mDispatchListeners) {
            intent = listener.dispatchAction(action, context, bundle);
            if (intent != null)
                break;
        }
        // 如果intent为空,既没有找到处理的listener,或者listener没有处理,什么也不做
        if (intent == null)
            return;

        if (intent != null && callBack != null)
            callBack.onJump(intent);
    }
}
