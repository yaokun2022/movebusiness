package com.yaokun.movebusiness.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.yaokun.movebusiness.utils.StatusBarUtil;

/**
 * 基础 Activity
 */
public abstract class BaseActivity extends AppCompatActivity  {
    public static String tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setImmersion(getWindow());
        StatusBarUtil.setTypewriting(this);

        tag = this.getClass().getSimpleName();
    }


    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void startActivity(Class<?> cls) {
        startActivity(cls, false);
    }

    public void startActivity(Class<?> cls, Boolean finish) {
        startActivity(new Intent(this, cls));
        if (finish) {
            finish();
        }
    }
}
