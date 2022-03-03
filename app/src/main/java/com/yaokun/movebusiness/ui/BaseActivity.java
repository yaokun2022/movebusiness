package com.yaokun.movebusiness.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.yaokun.movebusiness.utils.StatusBarUtil;

/**
 * 基础 Activity
 */
public abstract class BaseActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setImmersion(getWindow());
    }
}
