package com.yaokun.movebusiness.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yaokun.movebusiness.R;

/**
 * 首页界面
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void authClick(View view) {
        Intent intent = new Intent(this,AuthorizationActivity.class);
        startActivity(intent);
    }

    public void mineHomeClick(View view) {
        Intent intent = new Intent(this,MineHomeActivity.class);
        startActivity(intent);
        finish();
    }

    public void recordClick(View view) {
        Intent intent = new Intent(this, RecordActivity.class);
        startActivity(intent);
    }
}