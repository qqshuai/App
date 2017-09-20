package com.sqq.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.circle_progressbar).setOnClickListener(this);
        findViewById(R.id.btn_xg).setOnClickListener(this);
        findViewById(R.id.btn_pop).setOnClickListener(this);
        findViewById(R.id.btn_sticky).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.circle_progressbar:
                intent = new Intent(this, CircleActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_xg:
                intent = new Intent(this, XGActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_pop:
                intent = new Intent(this, PopActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_sticky:
                intent = new Intent(this, StickyViewActivity.class);
                startActivity(intent);
                break;
        }
    }
}
