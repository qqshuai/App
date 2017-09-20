package com.sqq.app.drawable;

import android.app.Activity;
import android.os.Bundle;

import com.sqq.app.R;

/**
 * @author shuaiqiangqiang
 * @version 1.0 2017/9/18
 * @since JDK 1.7
 */
public class RotateDrawableActivity extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate_drawable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
