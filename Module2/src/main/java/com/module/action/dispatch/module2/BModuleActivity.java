package com.module.action.dispatch.module2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.module.action.dispatch.lib.DispatchAction;
import com.module.action.dispatch.lib.DispatchManager;
import com.module.action.dispatch.lib.IJumpCallBack;

/**
 * Created by yangtianfei on 17/4/4.
 */

public class BModuleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_b);
        findViewById(R.id.to_a).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DispatchManager.getInstance().dispatchEvent(DispatchAction.JUMP_TO_A, BModuleActivity.this, null, new IJumpCallBack() {
                    @Override
                    public void onJump(Intent intent) {
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
