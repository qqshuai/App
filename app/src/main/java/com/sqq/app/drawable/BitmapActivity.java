package com.sqq.app.drawable;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.widget.ImageView;

import com.sqq.app.R;

/**
 * @author shuaiqiangqiang
 * @version 1.0 2017/9/18
 * @since JDK 1.7
 */
public class BitmapActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);

        View view = findViewById(R.id.view_bitmap);

        ImageView imageView = (ImageView) findViewById(R.id.image_view);
        ImageView imageView2 = (ImageView) findViewById(R.id.image_view_2);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.share_logo);
        RoundedBitmapDrawable bitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        bitmapDrawable.setCircular(true);
        imageView.setImageDrawable(bitmapDrawable);

        RoundedBitmapDrawable bitmapDrawable2 = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        bitmapDrawable2.setCircular(false);
        bitmapDrawable2.setCornerRadius(30);
        imageView2.setImageDrawable(bitmapDrawable2);
    }
}
