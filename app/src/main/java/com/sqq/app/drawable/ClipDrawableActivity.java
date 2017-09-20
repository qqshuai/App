package com.sqq.app.drawable;

import android.app.Activity;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.view.View;

import com.sqq.app.R;

/**
 * @author shuaiqiangqiang
 * @version 1.0 2017/9/18
 * @since JDK 1.7
 */
public class ClipDrawableActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_clip_drawable);
        View viewClip = findViewById(R.id.view_clip);
        ClipDrawable drawable = (ClipDrawable) viewClip.getBackground();
        drawable.setLevel(5000);
    }
}
