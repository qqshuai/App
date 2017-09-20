package com.sqq.app.drawable;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.sqq.app.R;

/**
 * @author shuaiqiangqiang
 * @version 1.0 2017/9/18
 * @since JDK 1.7
 */
public class AnimationDrawableActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_drawable);

        ImageView imageView = (ImageView) findViewById(R.id.image_view);
        AnimationDrawable drawable = (AnimationDrawable) imageView.getBackground();
        drawable.start();
    }
}
