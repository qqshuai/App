package com.sqq.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushManager;

/**
 * 信鸽推送
 *
 * @author shuaiqiangqiang
 * @version 1.0 2017/8/29
 * @since JDK 1.7
 */
public class XGActivity extends Activity implements View.OnClickListener {

    private static final String ACCOUNT = "123456";
    private static final String TAG = "wuhan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        XGPushManager.registerPush(this);

        setContentView(R.layout.activity_xg);
        findViewById(R.id.btn_register).setOnClickListener(this);
        findViewById(R.id.btn_unbind).setOnClickListener(this);
        findViewById(R.id.btn_unregister).setOnClickListener(this);
        findViewById(R.id.btn_tag).setOnClickListener(this);
        findViewById(R.id.btn_delete_tag).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:   // 注册
                XGPushManager.registerPush(this, ACCOUNT, new XGIOperateCallback() {
                    @Override
                    public void onSuccess(Object data, int flag) {
                        Log.w("TPush", "注册成功，设备token为：" + data);
                    }

                    @Override
                    public void onFail(Object data, int errCode, String msg) {
                        Log.w("TPush", "注册失败，错误码：" + errCode + ",错误信息：" + msg);
                    }
                });
                break;
            case R.id.btn_unbind:   // 解绑
                XGPushManager.registerPush(this, "*", new XGIOperateCallback() {
                    @Override
                    public void onSuccess(Object data, int flag) {
                        Log.w("TPush", "解绑成功，设备token为：" + data);
                    }

                    @Override
                    public void onFail(Object data, int errCode, String msg) {
                        Log.w("TPush", "解绑失败，错误码：" + errCode + ",错误信息：" + msg);
                    }
                });
                break;
            case R.id.btn_unregister:  // 反注册
                XGPushManager.unregisterPush(this, new XGIOperateCallback() {
                    @Override
                    public void onSuccess(Object data, int flag) {
                        Log.w("TPush", "反注册成功，设备token为：" + data);
                    }

                    @Override
                    public void onFail(Object data, int errCode, String msg) {
                        Log.w("TPush", "反注册失败，错误码：" + errCode + ",错误信息：" + msg);
                    }
                });
                break;
            case R.id.btn_tag:   // 设置标签
                XGPushManager.setTag(this, TAG);
                break;
            case R.id.btn_delete_tag:  // 删除标签
                XGPushManager.deleteTag(this, TAG);
                break;
        }
    }
}
