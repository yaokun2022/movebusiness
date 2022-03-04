package com.yaokun.movebusiness.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.yaokun.movebusiness.Constant;
import com.yaokun.movebusiness.R;

/**
 * 我的界面
 */
public class MineHomeActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_home);

        TextView textView = findViewById(R.id.phoneNumber);
        if (Constant.loginUser==null) {
            showToast("请登录后重试！");
            startActivity(LoginActivity.class);
            return;
        }
        textView.setText(Constant.loginUser.getUsername());

        findViewById(R.id.mh).setOnClickListener(view -> {
            startActivity(MainActivity.class, true);
            finish();
        });

    }

    public void changPwdClink(View view) {
        startActivity(ChangePasswordActivity.class);
    }

    public void exitClick(View view) {
        startActivity(LoginActivity.class, true);
    }
}
