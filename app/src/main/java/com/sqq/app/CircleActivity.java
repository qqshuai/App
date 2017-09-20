package com.sqq.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.dinuscxj.progressbar.CircleProgressBar;

/**
 * @author shuaiqiangqiang
 * @version 1.0 2017/8/28
 * @since JDK 1.7
 */
public class CircleActivity extends Activity {

    private static final String TAG = CircleActivity.class.getSimpleName();

    private CircleProgressBar cpb;
    private int count = 60;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (count >= 0) {
                cpb.setProgress(60 - count);
                count--;
                handler.sendEmptyMessageDelayed(0, 1000);
                Log.i(TAG, "===" + count);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_circle);

        cpb = (CircleProgressBar) findViewById(R.id.cpb);
        cpb.setProgressTextFormatPattern("%d");
        handler.sendEmptyMessage(0);
    }
}
