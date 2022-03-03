package com.yaokun.movebusiness.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.yaokun.movebusiness.R;
import com.yaokun.movebusiness.utils.StatusBarUtil;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void authClick(View view) {
        Intent intent = new Intent(MainActivity.this,AuthorizationActivity.class);
        startActivity(intent);
    }

    public void mineHomeClick(View view) {
        Intent intent = new Intent(MainActivity.this,MineHomeActivity.class);
        startActivity(intent);
        finish();
    }

    public void recordClick(View view) {
//        Intent intent = new Intent(MainActivity.this, AuthorizationRecordActivity.class);
//        startActivity(intent);
    }
}