package com.sqq.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

/**
 * @author shuaiqiangqiang
 * @version 1.0 2017/9/4
 * @since JDK 1.7
 */
public class PopActivity extends Activity {

    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pop);

        final Button btnPop = (Button) findViewById(R.id.btn_pop);
        btnPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (popupWindow != null) {
                    popupWindow.showAsDropDown(btnPop);
                    return;
                }
                View view = LayoutInflater.from(PopActivity.this).inflate(R.layout.pop_view, null);
                popupWindow = new PopupWindow(view);
                popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
                popupWindow.setHeight(300);
                popupWindow.showAsDropDown(btnPop);
            }
        });

        findViewById(R.id.btn_top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PopActivity.this, "test", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onBackPressed() {
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
            return;
        }
        super.onBackPressed();
    }
}
