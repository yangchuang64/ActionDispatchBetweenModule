package com.module.action.dispatch.lib;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by yangtianfei on 17/4/4.
 */

public interface IDispatchListener {
    Intent dispatchAction(String action, Context context, Bundle bundle);
}
