package com.yaokun.movebusiness.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.yaokun.movebusiness.R;
import com.yaokun.movebusiness.utils.PhoneUtils;


public class VerificationCodeActivity extends AppCompatActivity {
    private static CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Android状态栏与背景图完美沉浸
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        setContentView(R.layout.activity_pwd_verification_code);
        EditText userName = findViewById(R.id.verificationCode);
        Button button = findViewById(R.id.verificationCodeBtn);
        VerificationCode(button);
        userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String userNameCode = s.toString();
                if (PhoneUtils.checkPhone(userNameCode)) {
                    userName.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, getDrawable(R.mipmap.login_username_ic), null);
                } else {
                    userName.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);
                }
            }
        });
    }
    //页面跳转
    public void fpClick(View view) {
        Intent intent = new Intent(VerificationCodeActivity.this, RetrievePasswordActivity.class);
        startActivity(intent);
    }

    //获取验证码
    public void VerificationCode(View view){
        EditText editText = findViewById(R.id.verificationCode);
        Button button = findViewById(R.id.verificationCodeBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer = new CountDownTimer(60*1000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        //防止计时过程中重复点击
                        button.setClickable(false);
                        button.setText((millisUntilFinished / 1000) + "秒后获取");
                    }

                    @Override
                    public void onFinish() {
                        //重新给Button设置文字
                        button.setText("重新获取");
                        //设置可点击
                        button.setClickable(true);
                    }
                };
                countDownTimer.start();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null)
            countDownTimer.cancel();
        countDownTimer = null;
    }
}