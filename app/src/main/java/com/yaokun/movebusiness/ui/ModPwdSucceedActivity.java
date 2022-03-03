package com.yaokun.movebusiness.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.yaokun.movebusiness.R;

public class ModPwdSucceedActivity extends AppCompatActivity {
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acctivity_change_succeed);
        TextView textView = findViewById(R.id.tv1);
        countDownTimer = new CountDownTimer(3000, 1000) {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onTick(long millisUntilFinished) {
                SpannableStringBuilder ssb = new SpannableStringBuilder("系统将在" + millisUntilFinished / 1000 + "秒后自动登录，请凭修改后的密码重新登录。");
                ssb.setSpan(new ForegroundColorSpan(Color.rgb(0, 199, 255)), 4, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                textView.setText(ssb);
            }

            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();

        new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                Intent intent = new Intent(ModPwdSucceedActivity.this, LoginActivity.class);
                startActivity(intent);
                return false;
            }
        }).sendEmptyMessageDelayed(0, 3000);

        // Android状态栏与背景图完美沉浸
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

    }

}
