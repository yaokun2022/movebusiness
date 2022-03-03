package com.yaokun.movebusiness.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.yaokun.movebusiness.R;

public class RetrievePasswordActivity extends AppCompatActivity {
    private ImageView pwd;
    private ImageView pwd2;
    private EditText pwdEt;
    private EditText pwdEt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        // Android状态栏与背景图完美沉浸
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        pwd = findViewById(R.id.pwd);
        pwd2 = findViewById(R.id.pwd2);
        pwdEt = findViewById(R.id.pwdET);
        pwdEt2 = findViewById(R.id.pwdET2);

       // 切换密码、图标显示和隐藏
        pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pwd.isSelected()) {
                    pwd.setSelected(false);
                    pwdEt.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    pwd.setSelected(true);
                    pwdEt.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

        pwd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pwd2.isSelected()) {
                    pwd2.setSelected(false);
                    pwdEt2.setTransformationMethod(PasswordTransformationMethod.getInstance());

                } else {
                    pwd2.setSelected(true);
                    pwdEt2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RetrievePasswordActivity.this, ModPwdSucceedActivity.class);
                RetrievePasswordActivity.this.startActivity(intent);
            }
        });

    }

}
