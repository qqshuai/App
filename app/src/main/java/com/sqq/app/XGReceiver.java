package com.sqq.app;

import android.content.Context;
import android.util.Log;

import com.tencent.android.tpush.XGPushBaseReceiver;
import com.tencent.android.tpush.XGPushClickedResult;
import com.tencent.android.tpush.XGPushRegisterResult;
import com.tencent.android.tpush.XGPushShowedResult;
import com.tencent.android.tpush.XGPushTextMessage;

/**
 * @author shuaiqiangqiang
 * @version 1.0 2017/8/29
 * @since JDK 1.7
 */
public class XGReceiver extends XGPushBaseReceiver {

    private static final String TAG = "XGReceiver";

    @Override
    public void onRegisterResult(Context context, int errorCode, XGPushRegisterResult xgPushRegisterResult) {
        Log.w(TAG, "onRegisterResult:errorCode=" + errorCode + " token=" + xgPushRegisterResult.getToken());
    }

    @Override
    public void onUnregisterResult(Context context, int errorCode) {
        Log.w(TAG, "onUnregisterResult:errorCode=" + errorCode);
    }

    @Override
    public void onSetTagResult(Context context, int errorCode, String tagName) {
        Log.w(TAG, "onSetTagResult:errorCode=" + errorCode + " tagName=" + tagName);
    }

    @Override
    public void onDeleteTagResult(Context context, int errorCode, String tagName) {
        Log.w(TAG, "onDeleteTagResult:errorCode=" + errorCode + " tagName=" + tagName);
    }

    @Override
    public void onTextMessage(Context context, XGPushTextMessage xgPushTextMessage) {
        Log.e(TAG, "onTextMessage:title=" + xgPushTextMessage.getTitle());
        Log.e(TAG, "onTextMessage:content=" + xgPushTextMessage.getContent());
        Log.e(TAG, "onTextMessage:customContent=" + xgPushTextMessage.getCustomContent());
    }

    @Override
    public void onNotifactionClickedResult(Context context, XGPushClickedResult xgPushClickedResult) {
        Log.e(TAG, "onNotifactionClickedResult:title=" + xgPushClickedResult.getTitle());
    }

    @Override
    public void onNotifactionShowedResult(Context context, XGPushShowedResult xgPushShowedResult) {
        Log.e(TAG, "onNotifactionShowedResult:title=" + xgPushShowedResult.getTitle());
    }

}
