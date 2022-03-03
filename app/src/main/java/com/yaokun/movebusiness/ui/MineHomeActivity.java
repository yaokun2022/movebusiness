package com.yaokun.movebusiness.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.yaokun.movebusiness.R;

/**
 * 我的界面
 */
public class MineHomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_home);
        // Android状态栏与背景图完美沉浸
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        TextView textView = findViewById(R.id.phoneNumber);
        String cellPhone = getIntent().getStringExtra("data");
        textView.setText(cellPhone);


        findViewById(R.id.mh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MineHomeActivity.this,MainActivity.class);
                MineHomeActivity.this.startActivity(intent);
                finish();
            }
        });

    }

    public void ChangPwdClink(View view) {
        Intent intent = new Intent(MineHomeActivity.this, ChangePasswordActivity.class);
        startActivity(intent);
    }

    public void exitClick(View view) {
        Intent intent = new Intent(MineHomeActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}
